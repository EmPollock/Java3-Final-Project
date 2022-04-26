package com.pollock.finalproject;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;


public class Donation implements Serializable, Comparable<Donation>{
    private int id;
    private Instant dateTimeProcessed;
    private Double amount;
    private String frequency;
    private LocalDate ending;
    private String applyTo;
    private String note;
    private ArrayList<Person> donors;
    private boolean postAmount;
    private boolean postName;

    private static ArrayList<Integer> ids = new ArrayList<>();

    private static final int MIN_FREQUENCY_LENGTH = 1;
    private static final int MAX_FREQUENCY_LENGTH = 100;
    private static final int MIN_APPLY_TO_LENGTH = 1;
    private static final int MAX_APPLY_TO_LENGTH = 100;
    private static final int MIN_NOTE_LENGTH = 0;
    private static final int MAX_NOTE_LENGTH = 250;

    public Donation() {
        id = -1;
        dateTimeProcessed = Instant.now();
        amount = 0.00;
        frequency = "";
        ending = LocalDate.now();
        applyTo = "";
        note = "";
        donors = new ArrayList<Person>();
        postAmount = false;
        postName = false;
    }

    public Donation(String id, String dateTimeProcessed, String amount, String frequency, String ending,
                    String applyTo, String note, ArrayList<Person> donors, boolean postAmount, boolean postName) {
        try {
            setId(id);
            setDateTimeProcessed(dateTimeProcessed);
            setAmount(amount);
            setFrequency(frequency);
            setEnding(ending);
            setApplyTo(applyTo);
            setNote(note);
            this.donors = donors;
            setPostAmount(postAmount);
            setPostName(postName);
        } catch (Exception ex){
            throw ex;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(String id) {
        try{
            validateID(id);
        } catch(Exception ex){
            throw ex;
        }

        this.id = Integer.parseInt(id);
        ids.add(this.id);
    }

    private void validateID(String num){
        try{
            if(isAnInt(num)) {
                if (idExists(Integer.parseInt(num))) {
                    throw new IllegalArgumentException("ID already exists. Choose a new ID.");
                }
            } else{
                throw new IllegalArgumentException("ID provided is not a number.");
            }
        }catch (Exception ex){
            throw ex;
        }
    }

    public Instant getDateTimeProcessed() {
        return dateTimeProcessed;
    }

    public void setDateTimeProcessed(String dateTimeProcessed) {
        try {
            validateDateTimeProcessed(dateTimeProcessed);
        } catch (Exception ex){
            throw ex;
        }
        this.dateTimeProcessed = Instant.parse(dateTimeProcessed);
    }

    private void validateDateTimeProcessed(String dateTimeProcessed){
        try{
            Instant.parse(dateTimeProcessed);
        } catch (Exception ex){
            throw new IllegalArgumentException("Invalid Instant for Date Time Processed. Should be in the proper format (Example \"2018-11-30T18:35:24.00Z\")");
        }
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        try {
            validateAmount(amount);
        } catch (Exception ex){
            throw ex;
        }
        this.amount = Double.parseDouble(amount);
    }

    private void validateAmount(String amount){
        if(!isANumber(amount)){
            throw new IllegalArgumentException("Amount provided is not a number.");
        }
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        try {
            validateFrequency(frequency);
        } catch(Exception ex){
            throw ex;
        }
        this.frequency = frequency;
    }

    private void validateFrequency(String frequency){
        if(frequency.length() < MIN_FREQUENCY_LENGTH){
            throw new IllegalArgumentException("Frequency length is too short.");
        }
        if(frequency.length() > MAX_FREQUENCY_LENGTH){
            throw new IllegalArgumentException("Frequency length is too long.");
        }
    }

    public LocalDate getEnding() {
        return ending;
    }

    public void setEnding(String ending) {
        try {
            validateEnding(ending);
        } catch(Exception ex){
            throw ex;
        }
        this.ending = LocalDate.parse(ending);
    }

    private void validateEnding(String ending){
        try{
           LocalDate parsedDate = LocalDate.parse(ending);
           /*if(parsedDate.compareTo(LocalDate.now()) > 0){
               throw new IllegalArgumentException("Invalid ending date.");
           }*/
        } catch (Exception ex){
            throw new IllegalArgumentException("Invalid ending date.");
        }
    }

    public String getApplyTo() {
        return applyTo;
    }

    public void setApplyTo(String applyTo) {
        try{
            validateApplyTo(applyTo);
        } catch(Exception ex){
            throw ex;
        }
        this.applyTo = applyTo;
    }

    private void validateApplyTo(String applyTo){
        if(applyTo.length() < MIN_APPLY_TO_LENGTH){
            throw new IllegalArgumentException("Apply To is required.");
        }
        if(applyTo.length() > MAX_APPLY_TO_LENGTH){
            throw new IllegalArgumentException("Apply To is too long. Please keep Apply to under " + MAX_APPLY_TO_LENGTH + " characters.");
        }
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        try{
            validateNote(note);
        } catch(Exception ex){
            throw ex;
        }
        this.note = note;
    }

    private void validateNote(String note){
        if(note.length() < MIN_NOTE_LENGTH){
            throw new IllegalArgumentException("Note is too short. It must be at least " + MIN_NOTE_LENGTH + " characters long.");
        }
        if(note.length() > MAX_NOTE_LENGTH){
            throw new IllegalArgumentException("Note is too long. It must be shorter than " + MAX_NOTE_LENGTH + " characters long.");
        }
    }

    public ArrayList<Person> getDonors() {
        return donors;
    }

    public void setDonors(ArrayList<Person> donors) {
        try {
            this.donors = donors;
        } catch(Exception ex){
            throw ex;
        }
    }

    public void addDonor(Person donor){
        try {
            this.donors.add(donor);
        } catch(Exception ex){
            throw ex;
        }
    }

    public void removeDonor(Person donor){
        this.donors.remove(donor);
    }

    public boolean isPostAmount() {
        return postAmount;
    }

    public void setPostAmount(boolean postAmount) {
        this.postAmount = postAmount;
    }

    public boolean isPostName() {
        return postName;
    }

    public void setPostName(boolean postName) {
        this.postName = postName;
    }

    public Date getNewDateTimeProcessed(){
        return Date.from(dateTimeProcessed);
    }

    public boolean isANumber(String num){
        try{
            Double.parseDouble(num);
            return true;
        } catch(NumberFormatException ex){
            return false;
        }
    }
    public boolean isAnInt(String num){
        try{
            Integer.parseInt(num);
            return true;
        } catch(NumberFormatException ex){
            return false;
        }
    }

    public boolean idExists(int id){
        return ids.contains(id);
    }

    @Override
    public int compareTo(Donation o) {
        int result = this.dateTimeProcessed.compareTo(o.dateTimeProcessed);
        if(result == 0){
            result = (int)(this.amount - o.amount);
        }
        if(result == 0){
            result = this.ending.compareTo(o.ending);
        }
        return result;
    }

    public String toString(){
        String result = "";
        result += "ID: " + id + "\n"
                + "\t on " + getNewDateTimeProcessed() + ", \n";
        if(postName){
            if(donors.size() == 1){
                result += donors.get(0).getGivenName() + " " + donors.get(0).getFamilyName()
                        + " pledged to donate ";
            } else if(donors.size() == 2) {
                result += donors.get(0).getGivenName() + " " + donors.get(0).getFamilyName()
                        + "and " + donors.get(1).getGivenName() + " " + donors.get(1).getFamilyName()
                        + " pledged to donate ";
            }else {
                for (int i = 0; i < donors.size(); i++) {
                    if(i == donors.size()-1){
                        result += "and " + donors.get(i).getGivenName() + " " + donors.get(i).getFamilyName()
                                + " pledged to donate ";
                    } else{
                        result += donors.get(i).getGivenName() + " " + donors.get(i).getFamilyName() + ", ";
                    }
                }
            }
        } else{
            result += "an anonymous donor pledged to donate ";
        }

        if(postAmount){
            result += NumberFormat.getCurrencyInstance().format(amount) + " ";
        } else{
            result += "an anonymous amount ";
        }

        result += "to " + applyTo + "\nat a frequency of " + frequency
                + " until " + ending + ". \n" + "Their note was: \n\"" + note + "\"";

        return result;
    }
}
