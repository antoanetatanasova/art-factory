package bg.softuni.artfactory.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import static bg.softuni.artfactory.constant.Constants.*;

public class MessageSendBindingModel {

    @NotNull(message = MANDATORY_FIELD)
    @Length(min = 2, message = MIN_LENGTH)
    private String sender;
    @NotNull(message = MANDATORY_FIELD)
    @Email(message = INVALID_FORMAT)
    private String email;
    @NotNull(message = MANDATORY_FIELD)
    @Length(min = 3, message = MIN_LENGTH)
    private String subject;
    @NotNull(message = MANDATORY_FIELD)
    @Length(min = 10, message = MIN_LENGTH)
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