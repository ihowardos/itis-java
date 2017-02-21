package models;


import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Сергей on 06.12.2016.
 */
public class Prisoner {
    String firstname;
    String lastname;
    Date dateOfBirth;
    Date detention;
    Date released;
    int idPrison;
    int idPrisoner;
    LinkedList<Integer> articles;

    public Prisoner(String firstname, String lastname, Date dateOfBirth, Date detention, Date released, int idPrison, int idPrisoner) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.detention = detention;
        this.released = released;
        this.idPrison = idPrison;
        this.idPrisoner = idPrisoner;
    }

    public Prisoner(String firstname, String lastname, Date dateOfBirth, Date detention, Date released, LinkedList<Integer> articles, int idPrisoner) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.detention = detention;
        this.released = released;
        this.articles = articles;
        this.idPrisoner = idPrisoner;
    }


    public Prisoner(String firstname, String lastname, Date dateOfBirth, Date detention, Date released, int idPrison) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.detention = detention;
        this.released = released;
        this.idPrison = idPrison;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Date getDetention() {
        return detention;
    }

    public Date getReleased() {
        return released;
    }

    public int getIdPrison() {
        return idPrison;
    }

    public List<Integer> getArticles() {
        return articles;
    }

    public int getIdPrisoner() {
        return idPrisoner;
    }
}
