package com.pollock.ch03;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "MyServlet", value = "/kitty-cat/so-cute")
public class MyServlet extends HttpServlet {

    private final String DEFAULT_USER = "Guest";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user = request.getParameter("user");
        if(user == null){
            user = DEFAULT_USER;
        }

        try(PrintWriter out = response.getWriter();){
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en-US\">");
            out.println("<head>");
            out.println("<title>Servlet MyServlet</title>");
            out.println("<link href=\"" + request.getContextPath() + "/styles/styles.css\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Hello, " + user + "</h1>");
            out.println("<h1>Servlet MyServlet at " + request.getContextPath() + "</h1>");
            out.println("<p>Today is: " + getNow() + "</p>");
            out.println("<img src=\""+ request.getContextPath() + "/images/cat.jpg\" alt=\"Kitty Cat\">");
            out.println("</body>");
            out.println("</html>");
        }catch(Exception ex){

        }
    }

    private String getNow(){
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("LLLL dd, yyyy");
        return localDate.format(formatter);
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
