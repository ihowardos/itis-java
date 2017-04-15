package ru.itis.twitter.model;

import java.io.Serializable;

public enum UserProfileType implements Serializable {
    ADMIN("ADMIN"),
    DBA("DBA"),
    USER("USER");

    String userProfileType;

    private UserProfileType(String userProfileType) {
        this.userProfileType = userProfileType;
    }

    public String getUserProfileType() {
        return userProfileType;
    }
}

