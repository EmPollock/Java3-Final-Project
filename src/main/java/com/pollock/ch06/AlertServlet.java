package com.pollock.ch06;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

@WebServlet(name = "AlertServlet", value = "/alert/kirkwood")
public class AlertServlet extends HttpServlet {
    Hashtable<User, String> users;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("users") == null){
            Hashtable<User,String> newUsers = new Hashtable<User, String>();
            User user1 = (new User());
            user1.setUsername("tess-data@kirkwood.edu");
            user1.setFirstName("Tess");
            user1.setLastName("Data");

            Map<String, Boolean> permissions = new Hashtable<>();
            permissions.put("active", true);
            permissions.put("admin", true);
            permissions.put("super-admin", false);
            user1.setPermissions(permissions);
            newUsers.put(user1, "newuser");
            session.setAttribute("users", newUsers);
        }
        users = (Hashtable<User, String>)session.getAttribute("users");
        String go = request.getParameter("go");
        if(go == null){
            go = "profile";
        }
        switch(go){
            case "test":
                break;
            case "edit":
                break;
            case "notify":
                break;
            case "profile":
            default:
                viewProfile(request, response);
                break;
        }
    }

    private void viewProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = getUser(session);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/alert/viewProfile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private User getUser(HttpSession session){
        String username = (String)session.getAttribute("username");
        User user = null;
        for(User u : users.keySet()){
            if(u.getUsername().equals(username)){
                user = u;
                break;
            }
        }
        return user;
    }
}
