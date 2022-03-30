package com.pollock.songs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SongServlet", value = "/songs")
public class SongServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String go = (String)request.getParameter("go");

        switch(go){
            case "add":
                break;
            case "list":
                break;
            case "empty":
                break;
            case "remove":
                break;
            case "logout":
                break;
            case "view":
            default:

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
