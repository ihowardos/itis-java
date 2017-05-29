package ru.itis.model;

/**
 * Created by kair4 on 10.05.2017.
 */
public class User {
    private String token;

    public User(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
