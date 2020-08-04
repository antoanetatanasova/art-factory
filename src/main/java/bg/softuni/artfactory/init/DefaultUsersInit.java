package bg.softuni.artfactory.init;

import bg.softuni.artfactory.model.entity.RoleEntity;
import bg.softuni.artfactory.model.entity.UserEntity;
import bg.softuni.artfactory.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultUsersInit implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DefaultUsersInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            // admin
            UserEntity admin = new UserEntity();
            admin.setEmail("admin@example.com");
            admin.setPasswordHash(passwordEncoder.encode("artfactory"));

            RoleEntity adminAdminRole = new RoleEntity();
            adminAdminRole.setRole("ROLE_ADMIN");

            RoleEntity adminUserRole = new RoleEntity();
            adminUserRole.setRole("ROLE_USER");

            admin.setRoles(List.of(adminAdminRole, adminUserRole));

            userRepository.save(admin);

            // user
            UserEntity user = new UserEntity();
            user.setEmail("user@example.com");
            user.setPasswordHash(passwordEncoder.encode("artfactory"));

            RoleEntity userUserRole = new RoleEntity();
            userUserRole.setRole("ROLE_USER");

            user.setRoles(List.of(userUserRole));

            userRepository.save(user);
        }
    }

}