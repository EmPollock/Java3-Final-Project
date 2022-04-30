package com.pollock.finalproject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
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
                createDonation(request, response);
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

    private void createDonation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
