package com.pollock.finalproject;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;

public class DonationAccessor {
    private Integer nextID = 10000;
    private ArrayList<Donation> donations;

    public DonationAccessor(){
        donations = new ArrayList<Donation>();
        Person person1 = new Person("Tess", "Data", "tess@real.com");
        Person person2 = new Person("John", "Doe", "john@real.com");
        Person person3 = new Person("Simon", "Peter", "sipete@real.com");
        Person person4 = new Person("Greg", "Smith", "gregert@real.com");
        Person person5 = new Person("Richard", "Carlson", "rcarlson@real.com");
        Person person6 = new Person("Emilia", "Codder", "emcod@real.com");
        Person person7 = new Person("Noah", "Westwater", "noahman108@real.com");
        Person person8 = new Person("Micheal", "Habermann", "mookiepookie@real.com");

        ArrayList<Person> personArr1 = new ArrayList<>();
        personArr1.add(person2);
        donations.add(new Donation(nextID.toString(), "2021-11-30T18:35:24.00Z", "1000.00",
                "Monthly", "2022-04-30", "Cats", "Happy to help all the cute Kitten cats :)",
                personArr1, true, true));
        nextID++;

        ArrayList<Person> personArr2 = new ArrayList<>();
        personArr2.add(person6);
        personArr2.add(person7);
        donations.add(new Donation(nextID.toString(), "2020-07-14T10:42:13.38Z", "5000.00", "Yearly",
                "2025-07-14", "Medical Care", "Keep dem cuties healthy!!! SHOTS SHOTS SHOTS!!!!!", personArr2, false, true));
        nextID++;

        ArrayList<Person> personArr3 = new ArrayList<>();
        personArr3.add(person4);
        donations.add(new Donation(nextID.toString(), "2022-02-28T20:05:28.50Z", "50.00", "Weekly",
                "2023-02-28", "Old Dogs", "Can't teach an old dog new tricks, but I still love them.", personArr3, true, true));
        nextID++;

        ArrayList<Person> personArr4 = new ArrayList<>();
        personArr4.add(person1);
        donations.add(new Donation(nextID.toString(), "2021-05-09T07:48:21.78Z", "300.00", "Once",
                "2021-05-09", "Odds and Ends", "Happy to help with whatever you need :)", personArr4, false, false));
        nextID++;

        ArrayList<Person> personArr5 = new ArrayList<>();
        personArr5.add(person7);
        personArr5.add(person8);
        donations.add(new Donation(nextID.toString(), "2019-01-31T19:53:02.09Z", "50000.00", "Once",
                "2019-01-31", "Birds", "BIRDS!", personArr5, true, true));
        nextID++;

        ArrayList<Person> personArr6 = new ArrayList<>();
        personArr6.add(person3);
        personArr6.add(person5);
        donations.add(new Donation(nextID.toString(), "2017-09-05T08:20:22.06Z", "20.00", "Monthly",
                "2022-09-05", "Kibbles and Bits", "EAT MY PRETTIES! EAT!!!", personArr6, false, true));
        nextID++;

        ArrayList<Person> personArr7 = new ArrayList<>();
        personArr7.add(person5);
        donations.add(new Donation(nextID.toString(), "2021-05-09T07:48:21.78Z", "600.00", "Yearly",
                "2026-05-09", "Puppies", "Adopted my dog from here 2 years ago, wanna give some other pups a chance", personArr7, true, true));
        nextID++;

        ArrayList<Person> personArr8 = new ArrayList<>();
        personArr8.add(person5);
        donations.add(new Donation(nextID.toString(), "2020-06-25T10:13:57.21Z", "50.00", "Once",
                "2020-06-25", "Kittens", "Keep doin what you do :)", personArr8, false, true));
        nextID++;

        // 2 more
        ArrayList<Person> personArr9 = new ArrayList<>();
        personArr9.add(person6);
        donations.add(new Donation(nextID.toString(), "2022-04-21T21:14:32.06Z", "1200.00", "Monthly",
                "2022-04-21", "Odds and Ends", "", personArr9, false, false));
        nextID++;

        ArrayList<Person> personArr10 = new ArrayList<>();
        personArr10.add(person3);
        personArr10.add(person4);
        personArr10.add(person8);
        donations.add(new Donation(nextID.toString(), "2022-03-15T15:16:17.18Z", "5000.00", "Once",
                "2022-03-15", "Odds and Ends", "We love what you're doing, keep up the good work!", personArr10, false, false));
        nextID++;
    }

    public ArrayList<Donation> getDonations(){
        return donations;
    }
    public Donation SelectDonationByID(int donationID){
        Donation result = null;
        for(Donation d : donations){
            if(d.getId() == donationID){
                result = d;
                break;
            }
        }
        return result;
    }
}
