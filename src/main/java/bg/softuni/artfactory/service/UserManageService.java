package bg.softuni.artfactory.service;

import bg.softuni.artfactory.model.entity.UserEntity;

import java.util.List;

public interface UserManageService {

    void editUser(Long id);

    void deleteUser(Long id);

    List<UserEntity> findAll();

    boolean isAdmin(Long id);

    List<UserEntity> findAllAdmins();

    UserEntity findById(Long id);

}
