package bg.softuni.artfactory.model.entity;

import bg.softuni.artfactory.model.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name="roles")
public class RoleEntity extends BaseEntity {


        @Column(name="role", nullable=false)
        private String role;

    public RoleEntity() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}