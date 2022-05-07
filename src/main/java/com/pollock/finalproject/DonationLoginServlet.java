package com.pollock.finalproject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DonationLoginServlet", value = "/donation/login")
public class DonationLoginServlet extends HttpServlet {
    DonationUserAccessor userAccessor = new DonationUserAccessor();
    List<DonationUser> users;

    @Override
    public void init() throws ServletException {
        users = userAccessor.getUsers();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("user") != null){
            response.sendRedirect(request.getContextPath() + "/donation");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/final-project/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(userAccessor.authenticateUser(request.getParameter("email"), request.getParameter("password"))){
            session.setAttribute("user", userAccessor.getUserByEmail(request.getParameter("email")));
            request.changeSessionId();
            response.sendRedirect("../donation");
            return;
        }
        request.setAttribute("loginFailed", true);
        request.setAttribute("errorMsg", "Incorrect email or password.");
        request.getRequestDispatcher("/WEB-INF/final-project/login.jsp").forward(request, response);
    }
}
