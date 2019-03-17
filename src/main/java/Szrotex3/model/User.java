package Szrotex3.model;

import Szrotex3.service.Authorisation;
import Szrotex3.service.Container;

import java.sql.Date;
import java.util.Calendar;

public class User {

    private int id;
    private String email;
    private String password;
    private String salt;
    private Date createdAt;
    private String firstName;
    private String lastName;

    public User() {

    }

    public User(String email, String rawPassword, String firstName, String lastName) {
        this.email = email;
        this.createdAt = new Date(Calendar.getInstance().getTime().getTime());
        this.firstName = firstName;
        this.lastName = lastName;

        Authorisation authorisation = (Authorisation) Container.getBean("authorisation");
        this.salt = authorisation.createSalt();
        this.password = authorisation.generateHashedPassword(rawPassword, this.salt);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
