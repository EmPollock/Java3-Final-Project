package com.pollock.songs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Hashtable;

@WebServlet(name = "SongLoginServlet", value = "/login")
public class SongLoginServlet extends HttpServlet {
    private static final Hashtable<String, String> users = new Hashtable<>();

    @Override
    public void init() throws ServletException {
        users.put("TessData", "newuser");
        users.put("Emma", "P@ssw0rd");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(request.getParameter("logout")  != null){
            session.removeAttribute("username");
            request.setAttribute("loggedOut", true);
        }
        if(session.getAttribute("username") != null){
            response.sendRedirect("songs");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/songs/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        request.setAttribute("loginFailed", false);
        if(
                username == null || username.length() == 0 ||
                        password == null || password.length() == 0 ||
                        !users.containsKey(username) || !password.equals(users.get(username))
        ){
            request.setAttribute("loginFailed", true);
            request.setAttribute("errorMsg", "login attempt failed");
            request.getRequestDispatcher("/WEB-INF/songs/login.jsp").forward(request, response);
        } else{
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            request.changeSessionId();
            response.sendRedirect("songs");
        }


    }
}
