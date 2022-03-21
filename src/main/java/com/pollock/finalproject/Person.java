package com.pollock.finalproject;

public class Person {
    private String givenName;
    private String familyName;
    private String email;

    public Person() {
        givenName = "";
        familyName = "";
        email = "";
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
