package bg.softuni.artfactory.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "messages")
public class Message extends BaseEntity {

    @NotNull
    @Column(name = "sender")
    private String sender;
    @NotNull
    @Column(name = "email")
    private String email;
    @NotNull
    @Column(name = "subject")
    private String subject;
    @NotNull
    @Column(name = "body")
    private String body;

    public Message() {
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