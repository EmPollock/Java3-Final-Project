package com.pollock.finalproject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DonationServlet", value = "/donation")
public class DonationServlet extends HttpServlet {
    DonationAccessor donationAccessor = new DonationAccessor();
    ArrayList<Donation> donations;

    @Override
    public void init() throws ServletException {
        donations = donationAccessor.getDonations();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("donationList", donations);
        request.getRequestDispatcher("/WEB-INF/final-project/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
