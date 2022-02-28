package com.pollock.ch04b;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TemperatureConverter", value = "/ch04b/temp-converter")
public class TemperatureConverter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/ch04b/tempConverter.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("error", false);
        String FOrC = request.getParameter("FOrC");
        String inputTemp = request.getParameter("temp");

        if(FOrC == null){
            request.setAttribute("error", true);
            request.setAttribute("errorMsg", "Please select either Fahrenheit to Celsius or Celsius to Fahrenheit.");
        }
        else {
            Boolean FToC = FOrC.equals("F");
            try {
                Temperature t = new Temperature(inputTemp, FToC);
                request.setAttribute("t", t);
            } catch(Exception ex){
                request.setAttribute("error", true);
                request.setAttribute("errorMsg", ex.getMessage());
            }
        }
        request.getRequestDispatcher("/WEB-INF/ch04b/tempConverter.jsp").forward(request, response);
    }
}
