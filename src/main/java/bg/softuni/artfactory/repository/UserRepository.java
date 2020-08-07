package bg.softuni.artfactory.repository;

import bg.softuni.artfactory.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findOneByEmail(String email);

    UserEntity findOneById(Long id);

    List<UserEntity> findByRoles(String role);

}
