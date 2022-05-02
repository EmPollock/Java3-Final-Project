package com.pollock.ch07;

public class DirectoryPerson implements Comparable<DirectoryPerson>{
    private String firstName;
    private String lastName;
    private String picture;

    public DirectoryPerson() {
        this.firstName = "John";
        this.lastName = "Doe";
        this.picture = "";
    }

    public DirectoryPerson(String firstName, String lastName, String picture) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.picture = picture;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public int compareTo(DirectoryPerson other) {
        int result = this.lastName.compareToIgnoreCase(other.lastName);
        if(result == 0) {
            result = this.firstName.compareToIgnoreCase(other.firstName);
        }
        return result;
    }
}
