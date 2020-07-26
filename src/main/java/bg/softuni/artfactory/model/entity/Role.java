package bg.softuni.artfactory.model.entity;

import bg.softuni.artfactory.model.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name="roles")
public class Role extends BaseEntity {


        @Column(name="role", nullable=false)
        private String role;

    public Role() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}