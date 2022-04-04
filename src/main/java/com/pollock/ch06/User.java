package com.pollock.ch06;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

// It's a JavaBean!!! is Serializable (or Externalizable), has a default constructor, and has getters and setters
    // for all private instance variables using standard naming conventions
public class User implements Serializable{ // setting a non-serializable as a session attribute throws an error
    private long userID;
    private String username;
    private String firstName;
    private String lastName;
    private boolean likesPizza;
    private Map<String, Boolean> permissions = new HashMap<>();

    public User() {
        this.userID = 0L;
        this.username = "";
        this.firstName = "";
        this.lastName = "";
        this.likesPizza = true;
    }

    public User(long userID, String username, String firstName, String lastName) {
        this.userID = userID;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.likesPizza = true;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Map<String, Boolean> getPermissions() {
        return permissions;
    }

    public void setPermissions(Map<String, Boolean> permissions) {
        this.permissions = permissions;
    }

    public boolean isLikesPizza() {
        return likesPizza;
    }

    public void setLikesPizza(boolean likesPizza) {
        this.likesPizza = likesPizza;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
