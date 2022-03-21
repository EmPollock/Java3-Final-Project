package com.pollock.finalproject;

//import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Donation implements Comparable<Donation>{
    private int id;
    private LocalDateTime dateTimeProcessed;
    private double amount;
    private String frequency;
    private LocalDate ending;
    private String applyTo;
    private String note;
    private Person donor;
    private boolean postAmount;
    private boolean postName;

    private static final int MIN_FREQUENCY_LENGTH = 1;
    private static final int MAX_FREQUENCY_LENGTH = 100;

    public Donation() {
        id = -1;
        dateTimeProcessed = LocalDateTime.now();
        amount = 0.00;
        frequency = "";
        ending = LocalDate.now();
        applyTo = "";
        note = "";
        donor = new Person();
        postAmount = false;
        postName = false;
    }

    public Donation(String id, String dateTimeProcessed, String amount, String frequency, String ending,
                    String applyTo, String note, Person donor, boolean postAmount, boolean postName) {
        try {
            setId(id);
            setDateTimeProcessed(dateTimeProcessed);
            setAmount(amount);
            setFrequency(frequency);
            setEnding(ending);
            this.applyTo = applyTo;
            this.note = note;
            this.donor = donor;
            this.postAmount = postAmount;
            this.postName = postName;
        } catch (Exception ex){
            throw ex;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(String id) {
        validateID(id);
        this.id = Integer.parseInt(id);
    }

    private void validateID(String num){
        try{
            isAnInt(num);
        }catch (Exception ex){
            throw ex;
        }
    }

    public LocalDateTime getDateTimeProcessed() {
        return dateTimeProcessed;
    }

    public void setDateTimeProcessed(String dateTimeProcessed) {
        validateDateTimeProcessed(dateTimeProcessed);
        this.dateTimeProcessed = LocalDateTime.parse(dateTimeProcessed, DateTimeFormatter.ofPattern("yyyy-mm-dd, hh:mm"));
    }

    private void validateDateTimeProcessed(String dateTimeProcessed){
        try{
            LocalDateTime.parse(dateTimeProcessed, DateTimeFormatter.ofPattern("yyyy-mm-dd, hh:mm"));
        } catch (Exception ex){
            throw new IllegalArgumentException("Invalid date.");
        }
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        validateAmount(amount);
        this.amount = Double.parseDouble(amount);
    }

    private void validateAmount(String amount){
        try{
            isANumber(amount);
        } catch(Exception ex){
          throw ex;
        }
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        validateFrequency(frequency);
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
        validateEnding(ending);
        this.ending = LocalDate.parse(ending, DateTimeFormatter.ofPattern("yyyy-mm-dd"));
    }

    private void validateEnding(String ending){
        try{
           LocalDate parsedDate = LocalDate.parse(ending, DateTimeFormatter.ofPattern("yyyy-mm-dd"));
           if(parsedDate.compareTo(LocalDate.now()) > 0){
               throw new IllegalArgumentException("Invalid ending date.");
           }
        } catch (Exception ex){
            throw new IllegalArgumentException("Invalid ending date.");
        }
    }

    public String getApplyTo() {
        return applyTo;
    }

    public void setApplyTo(String applyTo) {
        this.applyTo = applyTo;
    }

    private void validateApplyTo(){
        //throw new NotImplementedException();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    private void validateNote(){
        //throw new NotImplementedException();
    }

    public Person getDonor() {
        return donor;
    }

    public void setDonor(Person donor) {
        this.donor = donor;
    }

    private void validateDonor(){
        //throw new NotImplementedException();
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

    public Date newDateTimeProcessed(){
        //throw new NotImplementedException();
        return new Date();
    }

    public void isANumber(String num){
        try{
            Double.parseDouble(num);
        } catch(NumberFormatException ex){
            throw new IllegalArgumentException("Invalid number");
        }
    }
    public void isAnInt(String num){
        try{
            Integer.parseInt(num);
        } catch(NumberFormatException ex){
            throw new IllegalArgumentException("Invalid number");
        }
    }

    @Override
    public int compareTo(Donation o) {
        return 0;
    }
}
