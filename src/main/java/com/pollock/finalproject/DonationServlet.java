package com.pollock.finalproject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(name = "DonationServlet", value = "/donation")
public class DonationServlet extends HttpServlet {
    DonationAccessor donationAccessor = new DonationAccessor();
    ArrayList<Donation> donations;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "list";
        }
        switch(action){
            case "view":
                donationDetails(request, response);
                break;
            case "donate":
                showDonationForm(request, response);
                break;
            case "my-donations":

                break;
            case "stats":

                break;
            case "list":
            default:
                viewDonations(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("error", false);
        try {
            createDonation(request, response);
        }
        catch(Exception ex){
            request.setAttribute("error", true);
            request.setAttribute("errorMsg", ex.getMessage());
        }
        request.setAttribute("donationSubmitted", true);
        request.getRequestDispatcher("/WEB-INF/final-project/donate.jsp").forward(request, response);
    }

    private void createDonation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            ArrayList<Person> donors = new ArrayList<>();
            String givenName1 = request.getParameter("givenName1");
            if(givenName1 == null || givenName1.equals("")){
                request.setAttribute("givenName1Error","Please input at least one donor.");
            }
            String familyName1 = request.getParameter("familyName1");
            String email1 = request.getParameter("email1");
            if(familyName1 == null || familyName1.equals("") || email1 == null || email1.equals("")){
                request.setAttribute("familyName1Error", "Please finish filling out person 1 information.");
            }

            String givenName2 = request.getParameter("givenName2");
            String familyName2 = request.getParameter("familyName2");
            String email2 = request.getParameter("email2");
            boolean person2Exists = false;
            // if the user has filled out any info for person 2
            if(givenName2 != null && !givenName2.equals("") && familyName2 != null && !familyName2.equals("")
                    && email2 != null || !email2.equals("")){
                // if the user hasn't filled out all info for person 2 (email not required)
                if(givenName2 == null || givenName2.equals("") || familyName1 == null || familyName2.equals("")) {
                    request.setAttribute("givenName2Error","Please finish filling out person 2 information.");
                }
                person2Exists = true;
            }

            String givenName3 = request.getParameter("givenName3");
            String familyName3 = request.getParameter("familyName3");
            String email3 = request.getParameter("email3");
            boolean person3Exists = false;
            // if the user has filled out any info for person 3
            if(givenName3 != null && !givenName3.equals("") && familyName3 != null && !familyName3.equals("")
                    && email3 != null || !email3.equals("")){
                // if the user hasn't filled out all info for person 2 (email not required)
                if(givenName3 == null || givenName3.equals("") || familyName3 == null || familyName3.equals("")) {
                    request.setAttribute("givenName3Error","Please finish filling out person 3 information.");
                }
                person3Exists = true;
            }

            donors.add(new Person(givenName1, familyName1, email1));
            if(person2Exists){
                donors.add(new Person(givenName2, familyName2, email2));
            }
            if(person3Exists){
                donors.add(new Person(givenName3, familyName3, email3));
            }

            Donation donation = new Donation();

            try{
                donation.setAmount(request.getParameter("amount"));
            } catch (Exception ex){
                request.setAttribute("amountError", ex.getMessage());
            }
            try{
                donation.setFrequency(request.getParameter("frequency"));
            } catch (Exception ex){
                request.setAttribute("frequencyError", ex.getMessage());
            }
            try{
                donation.setEnding(request.getParameter("endingDate"));
            } catch (Exception ex){
                request.setAttribute("endingDateError", ex.getMessage());
            }
            try{
                donation.setApplyTo(request.getParameter("applyTo"));
            } catch (Exception ex){
                request.setAttribute("applyToError", ex.getMessage());
            }
            try{
                donation.setNote(request.getParameter("note"));
            } catch (Exception ex){
                request.setAttribute("noteError", ex.getMessage());
            }

            donation.setPostAmount(request.getParameter("postAmount").equals("true"));
            donation.setPostName(request.getParameter("postName").equals("true"));
            donation.setDateTimeProcessed(Instant.now().toString());
            donation.setDonors(donors);

            donationAccessor.InsertDonation(donation);
        } catch(Exception ex){
            throw ex;
        }
        request.setAttribute("donationSubmitted", true);
        request.getRequestDispatcher("/WEB-INF/final-project/donate.jsp").forward(request, response);
    }

    private void viewDonations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("donationList", donationAccessor.getDonations());
        request.getRequestDispatcher("/WEB-INF/final-project/index.jsp").forward(request, response);
    }


    private void donationDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString = request.getParameter("donationID");
        request.setAttribute("error", false);
        if(isAnInt(idString)){
            Donation donation = donationAccessor.SelectDonationByID(Integer.parseInt(idString));
            if(donation == null){
                request.setAttribute("error", true);
                request.setAttribute("errorMsg", "Something went wrong. Please pick a different donation to view.");
            }
            request.setAttribute("donation", donation);
        } else{
            request.setAttribute("error", true);
            request.setAttribute("errorMsg", "Something went wrong. Please pick a different donation to view.");
        }
        request.getRequestDispatcher("/WEB-INF/final-project/donationDetails.jsp").forward(request, response);
    }

    private void showDonationForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/final-project/donate.jsp").forward(request, response);
    }

    private boolean isAnInt(String str){
        try{
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException ex){
            return false;
        }
    }
}
