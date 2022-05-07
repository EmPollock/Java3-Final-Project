package com.pollock.finalproject;

import java.util.regex.Pattern;

public class Person {
    private String givenName;
    private String familyName;

    public static final int MIN_GIVEN_NAME_LENGTH = 1;
    public static final int MAX_GIVEN_NAME_LENGTH = 200;
    public static final int MIN_FAMILY_NAME_LENGTH = 1;
    public static final int MAX_FAMILY_NAME_LENGTH = 200;

    public Person() {
        givenName = "";
        familyName = "";
    }

    public Person(String givenName, String familyName) {
        setGivenName(givenName);
        setFamilyName(familyName);
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        try{
            validateGivenName(givenName);
        } catch(Exception ex){
            throw ex;
        }
        this.givenName = givenName;
    }

    private void validateGivenName(String givenName){
        if(givenName.length() < MIN_GIVEN_NAME_LENGTH){
            throw new IllegalArgumentException("Given name is too short. It must be at least " + MIN_GIVEN_NAME_LENGTH + " characters long.");
        }
        if(givenName.length() > MAX_GIVEN_NAME_LENGTH){
            throw new IllegalArgumentException("Given name is too long. It must be shorter than " + MAX_GIVEN_NAME_LENGTH + " characters long.");
        }
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        try{
            validateFamilyName(familyName);
        } catch(Exception ex){
            throw ex;
        }
        this.familyName = familyName;
    }

    private void validateFamilyName(String familyName){
        if(familyName.length() < MIN_FAMILY_NAME_LENGTH){
            throw new IllegalArgumentException("Family name is too short. It must be at least " + MIN_FAMILY_NAME_LENGTH + " characters long.");
        }
        if(familyName.length() > MAX_FAMILY_NAME_LENGTH){
            throw new IllegalArgumentException("Family name is too long. It must be shorter than " + MAX_FAMILY_NAME_LENGTH + " characters long.");
        }
    }
}
