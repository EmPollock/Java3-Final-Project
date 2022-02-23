package com.pollock.ch04b;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AverageServlet", value = "/ch04b/average")
public class AverageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/ch04b/average.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");
        String num3 = request.getParameter("num3");

        AverageModel am = new AverageModel(num1, num2, num3);
        String average = am.getAverage();

        System.out.println(average);

        request.getRequestDispatcher("/WEB-INF/ch04b/average.jsp").forward(request, response);
    }
}
