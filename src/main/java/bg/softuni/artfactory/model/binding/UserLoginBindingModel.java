package bg.softuni.artfactory.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UserLoginBindingModel {

    private String email;
    private String password;

    public UserLoginBindingModel() {
    }

    @NotNull
    @Email(message = "Форматът на имейла е невалиден")
    public String getUsername() {
        return email;
    }

    public void setUsername(String username) {
        this.email = email;
    }

    @NotNull
    @Length(min = 3, message = "Паролата трябва да бъде по-дълга от {min} символа!")
    @Length(max = 20, message = "Паролата трябва да бъде по-кратка от {max} символа!")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}