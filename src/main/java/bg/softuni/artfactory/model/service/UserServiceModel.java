package bg.softuni.artfactory.model.service;

public class UserServiceModel extends BaseServiceModel {

    private String email;
    private String password;

    public UserServiceModel() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}