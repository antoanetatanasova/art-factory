package bg.softuni.artfactory.model;

import javax.persistence.*;

@Entity
@Table(name="roles")
public class Role {

        @Id
        @Column(name="id", nullable=false, updatable=false)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(name="role", nullable=false)
        private String role;

    public Role() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}