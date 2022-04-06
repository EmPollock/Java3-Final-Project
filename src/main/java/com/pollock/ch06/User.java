package com.pollock.ch06;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// It's a JavaBean!!! is Serializable (or Externalizable), has a default constructor, and has getters and setters
    // for all private instance variables using standard naming conventions
public class User implements Serializable, Comparable<User>{ // setting a non-serializable as a session attribute throws an error
    private long userID;
    private String username;
    private String firstName;
    private String lastName;
    private Map<String, Boolean> permissions = new HashMap<>();
    private String phoneNumber;
    private LocalDate birthday;
    private Instant lastUpdated;
    private BigDecimal balance;

    public User() {
        this.userID = 0L;
        this.username = "";
        this.firstName = "";
        this.lastName = "";
        this.phoneNumber = "";
        this.birthday = LocalDate.now();
        this.lastUpdated = Instant.now();
        this.balance = BigDecimal.ZERO;
    }

    public User(long userID, String username, String firstName, String lastName, String phoneNumber, LocalDate birthday, Instant lastUpdated, BigDecimal balance) {
        this.userID = userID;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.lastUpdated = lastUpdated;
        this.balance = balance;
    }

    public Date getNewLastUpdatedDate(){
        return Date.from(lastUpdated);
    }

    public Date getBirthdayDate(){
        return java.sql.Date.valueOf(birthday);
    }

    public void setStringToBirthday(String birthday) {
        DateTimeFormatter formatterInput = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            this.birthday = LocalDate.parse(birthday, formatterInput);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format for birthday");
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Birthday required");
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Instant getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Instant lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
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

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public int compareTo(User o) {
        int result = this.lastName.compareTo(o.lastName);
        if(result == 0){
            result = this.firstName.compareTo(o.firstName);
        }
        if(result == 0){
            result = this.username.compareTo(o.username);
        }
        return result;
    }
}
