package ru.itis.twitter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "roles")
public class UserProfile implements Serializable {

    @Id
    private long id;

    @Column(name = "type", nullable = false, length = 15, unique = true)
    private String type = UserProfileType.USER.getUserProfileType();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
