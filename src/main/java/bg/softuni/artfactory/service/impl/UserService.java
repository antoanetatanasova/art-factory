package bg.softuni.artfactory.service.impl;

import bg.softuni.artfactory.model.entity.RoleEntity;
import bg.softuni.artfactory.model.entity.UserEntity;
import bg.softuni.artfactory.model.view.UserManageViewModel;
import bg.softuni.artfactory.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserDetailsService userDetailsService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    public boolean existsUser(String email) {
        Objects.requireNonNull(email);

        return userRepository.findOneByEmail(email).isPresent();
    }

    public UserEntity getOrCreateUser(String email) {

        Objects.requireNonNull(email);

        Optional<UserEntity> userEntityOpt =
                userRepository.findOneByEmail(email);

        return userEntityOpt.
                orElseGet(() -> createUser(email));
    }

    public void createAndLoginUser(String email, String password) {
        UserEntity newUser = createUser(email, password);
        UserDetails userDetails = userDetailsService.loadUserByUsername(newUser.getEmail());

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails,
                password,
                userDetails.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private UserEntity createUser(String email, String password) {
        LOGGER.info("Creating a new user with email [GDPR].");
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(email);
        if (password != null) {
            userEntity.setPasswordHash(passwordEncoder.encode(password));
        }

        RoleEntity userRole = new RoleEntity();
        userRole.setRole("ROLE_USER");

        userEntity.setRoles(List.of(userRole));

        return userRepository.save(userEntity);
    }

    private UserEntity createUser(String email) {
        return createUser(email, null);
    }

}