package com.pollock.ch04;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "VoiceIn", value = "/ch04/voice-in")
public class VoiceIn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/xml");
        try(PrintWriter out = response.getWriter()){
            out.println("<Response>");
            out.println("<Say voice=\"Polly.Joanna\">");
            out.println("Howdy neighbor!");
            out.println("</Say>");
            out.println("<Pause length=\"3\"/>");
            out.println("<Say voice=\"Polly.Joanna\">");
            out.println("Goodbye.");
            out.println("</Say>");
            out.println("</Response>");
        }
    }
}
