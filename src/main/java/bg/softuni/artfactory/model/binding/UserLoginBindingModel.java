package bg.softuni.artfactory.model.binding;

import static bg.softuni.artfactory.common.constant.Constants.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UserLoginBindingModel {

    @NotNull(message = MANDATORY_FIELD)
    @Email(message = INVALID_FORMAT)
    private String email;
    @NotNull
    @Length(min = 3, message = MIN_LENGTH)
    @Length(max = 20, message = MAX_LENGTH)
    private String password;

    public UserLoginBindingModel() {
    }

    public String getUsername() {
        return email;
    }

    public void setUsername(String username) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}