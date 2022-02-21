package com.pollock.ch04;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SMSIn", value = "/ch04/sms-in")
public class SMSIn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/xml");
        try (PrintWriter out = response.getWriter()){
            out.println("<Response>");
            out.println("<Message>");
            out.println("Howdy neighbor!");
            out.println("</Message>");
            out.println("</Response>");
        }
    }
}
