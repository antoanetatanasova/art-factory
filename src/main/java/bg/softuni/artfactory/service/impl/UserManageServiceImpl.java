package bg.softuni.artfactory.service.impl;

import bg.softuni.artfactory.model.entity.RoleEntity;
import bg.softuni.artfactory.model.entity.UserEntity;
import bg.softuni.artfactory.repository.RoleRepository;
import bg.softuni.artfactory.repository.UserRepository;
import bg.softuni.artfactory.service.RoleManageService;
import bg.softuni.artfactory.service.UserManageService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserManageServiceImpl implements UserManageService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final RoleManageService roleManageService;

    public UserManageServiceImpl(UserRepository userRepository, RoleRepository roleRepository, RoleManageService roleManageService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.roleManageService = roleManageService;
    }

    @Override
    public void editUser(Long id) {
        UserEntity user = this.userRepository.findOneById(id);
        RoleEntity userRole = new RoleEntity();
        if(!user.getRoles().contains("ROLE_ADMIN")) {
            userRole.setRole("ROLE_ADMIN");
        }
        user.setRoles(List.of(userRole));
        userRepository.saveAndFlush(user);
    }

    @Override
    public void deleteUser(Long id) {
        this.userRepository.delete(userRepository.findOneById(id));
    }

    @Override
    public List<UserEntity> findAll() {
        return this.userRepository
                .findAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    @GetMapping("/admin")
    public boolean isAdmin(Long id) {
        return this.userRepository.getOne(id).getRoles()
                .contains(this.roleRepository.findByRole("ROLE_ADMIN"));
    }

    @Override
    public List<UserEntity> findAllAdmins() {
        return this.userRepository.findByRoles("ROLE_ADMIN");
    }

    @Override
    public UserEntity findById(Long id) {
        return null;
    }
}
