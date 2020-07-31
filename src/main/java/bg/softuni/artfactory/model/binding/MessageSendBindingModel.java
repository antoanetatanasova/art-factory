package bg.softuni.artfactory.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class MessageSendBindingModel {

    @NotNull
    @Length(min = 2, message = "Въведете поне {min} символа.")
    private String sender;
    @NotNull
    @Email(message = "Невалиден формат.")
    private String email;
    @NotNull
    @Length(min = 3, message = "Въведете поне {min} символа.")
    private String subject;
    @NotNull
    @Length(min = 10, message = "Въведете поне {min} символа.")
    private String body;

    public MessageSendBindingModel() {
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}