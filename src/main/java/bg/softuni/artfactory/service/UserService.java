package bg.softuni.artfactory.service;

import bg.softuni.artfactory.model.entity.UserEntity;

public interface UserService {
    boolean existsUser(String email);

    UserEntity getOrCreateUser(String email);

    void createAndLoginUser(String email, String password);

}