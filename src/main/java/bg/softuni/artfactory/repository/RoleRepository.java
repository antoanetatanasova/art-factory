package bg.softuni.artfactory.repository;

import bg.softuni.artfactory.model.entity.RoleEntity;
import bg.softuni.artfactory.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

RoleEntity findByRole(String role);

}
