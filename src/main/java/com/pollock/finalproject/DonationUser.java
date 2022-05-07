package com.pollock.finalproject;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class DonationUser implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Map<String, Boolean> permissions;
    private LocalDate birthday;

    public static final int MIN_FIRST_NAME_LENGTH = 1;
    public static final int MAX_FIRST_NAME_LENGTH = 200;
    public static final int MIN_LAST_NAME_LENGTH = 1;
    public static final int MAX_LAST_NAME_LENGTH = 200;

    public DonationUser() {
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.password = "";
        this.permissions = new HashMap<String, Boolean>();
        this.birthday = LocalDate.now();
    }

    public DonationUser(String firstName, String lastName, String email, String password, Map<String, Boolean> permissions, String birthday) {
        try {
            setFirstName(firstName);
            setLastName(lastName);
            setEmail(email);
            setPassword(password);
            setPermissions(permissions);
            setBirthday(birthday);
        } catch (Exception ex){
            throw ex;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        try{
            validateFirstName(firstName);
            this.firstName = firstName;
        } catch (Exception ex){
            throw ex;
        }
    }

    public void validateFirstName(String firstName){
        if(firstName.length() < MIN_FIRST_NAME_LENGTH){
            throw new IllegalArgumentException("First name is too short. It must be at least " + MIN_FIRST_NAME_LENGTH + " characters long.");
        }
        if(firstName.length() > MAX_FIRST_NAME_LENGTH){
            throw new IllegalArgumentException("First name is too long. It must be shorter than " + MAX_FIRST_NAME_LENGTH + " characters long.");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        try {
            this.lastName = lastName;
        } catch (Exception ex){
            throw ex;
        }
    }

    public void validateLastName(String lastName){
        if(lastName.length() < MIN_LAST_NAME_LENGTH){
            throw new IllegalArgumentException("Last name is too short. It must be at least " + MIN_LAST_NAME_LENGTH + " characters long.");
        }
        if(lastName.length() > MAX_LAST_NAME_LENGTH){
            throw new IllegalArgumentException("Last name is too long. It must be shorter than " + MAX_LAST_NAME_LENGTH + " characters long.");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        try {
            validateEmail(email);
            this.email = email;
        } catch (Exception ex){
            throw ex;
        }
    }

    private void validateEmail(String email){
        // based on examples on https://www.baeldung.com/java-email-validation-regex
        if(!Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
                .matcher(email)
                .matches())
        {
            throw new IllegalArgumentException("Invalid email.");
        }
    }

    public boolean authenticatePassword(String password) {
        return this.password.equals(password);
    }

    public void setPassword(String password) {
        try {
            validatePassword(password);
            this.password = password;
        } catch (Exception ex){
            throw ex;
        }
    }

    private void validatePassword(String password){
        if(password.length() < 8){
            throw new IllegalArgumentException("Password must be at least 8 characters long.");
        }
        if(password.length() > 20){
            throw new IllegalArgumentException("Password length cannot be more than 20 characters.");
        }
        // regex from https://www.geeksforgeeks.org/how-to-validate-a-password-using-regular-expressions-in-java/
        if(!Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{8,20}$")
                .matcher(password)
                .matches())
        {
            throw new IllegalArgumentException("Invalid password. Must have a number, an upper case letter, a lowercase letter, and a symbol");
        }
    }

    public Map<String, Boolean> getPermissions() {
        return permissions;
    }

    public void setPermissions(Map<String, Boolean> permissions) {
        this.permissions = permissions;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        try {
            validateBirthday(birthday);
            this.birthday = LocalDate.parse(birthday);
        } catch (Exception ex){
            throw ex;
        }
    }

    public void validateBirthday(String birthday){
        try{
            LocalDate parsedDate = LocalDate.parse(birthday);
           if(parsedDate.isAfter(LocalDate.now()) || parsedDate.isEqual(LocalDate.now())){
               throw new IllegalArgumentException("Invalid birthday.");
           }
        } catch (Exception ex){
            throw new IllegalArgumentException("Invalid birthday.");
        }
    }

    @Override
    public String toString() {
        String result = firstName + " " + lastName + "\n" +
                "Email: " + email + "\n" +
                "Birthday: " + birthday.toString() + "\n" +
                "Permission: \n";
        // if permission user has permission, add the permission to the string
        for(String perm : permissions.keySet()){
            if(permissions.get(perm)){
                result += perm + "\n";
            }
        }
        return result;
    }
}
