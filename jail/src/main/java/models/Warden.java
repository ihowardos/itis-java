package models;

import java.util.Date;

/**
 * Created by Сергей on 26.11.2016.
 */
public class Warden {
    String email;
    String firstname;
    String lastname;
    String password;
    java.sql.Date dateOfBirth;

    public Warden(String email, String password, java.sql.Date dateOfBirth, String firstname, String lastname){
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
