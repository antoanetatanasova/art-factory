package bg.softuni.artfactory.model.view;

import javax.management.relation.Role;
import java.util.Set;

public class UserManageViewModel {

    public class MessageViewModel {

        private Long id;
        private String email;
        private Set<Role> roles;

        public MessageViewModel() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Set<Role> getRoles() {
            return roles;
        }

        public void setRoles(Set<Role> roles) {
            this.roles = roles;
        }
    }

}