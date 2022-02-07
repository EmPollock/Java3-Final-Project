package com.pollock.ch03;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

@WebServlet(name = "AdditionServlet", value = "/add")
public class AdditionServlet extends HttpServlet {

    private PrintWriter writeHeader (HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();

        writer  .append("<!DOCTYPE HTML>\r\n")
                .append("<html>\r\n")
                .append("<head>\r\n")
                .append("<title>Addition Servlet</title>\r\n")
                .append("</head>\r\n")
                .append("<body>\r\n")
                .append("<h1>Add two numbers</h1>\r\n");

        return writer;
    }

    private void showForm(PrintWriter writer){
        writer  .append("<h2>Enter two numbers and press Calculate to add them.</h2>")
                .append("<form action=\"\" method=\"POST\">")
                .append("<input type=\"text\" name=\"firstNumber\" placeholder=\"Enter a number\">")
                .append("<input type=\"text\" name=\"secondNumber\" placeholder=\"Enter another number\">")
                .append("<input type=\"submit\" value=\"Calculate\">")
                .append("</form>");
    }

    private void writeFooter (PrintWriter writer) throws IOException {
        writer  .append("</body>\r\n")
                .append("</html>");
        writer.close();
    }

    private String add(String firstNumber, String secondNumber){
        String result = "<strong>Error:</strong> Invalid input. Try again.";

        if (isANumber(firstNumber) && isANumber(secondNumber)){
            BigDecimal num1 = new BigDecimal(firstNumber);
            BigDecimal num2 = new BigDecimal(secondNumber);
            BigDecimal total = num1.add(num2);

            DecimalFormat df = new DecimalFormat("#, ##0.00");
            String n1 = df.format(num1);
            String n2 = df.format(num2);
            String totalStr = df.format(total);

            result = "<strong>Result:</strong> " + n1 + " + " + n2 + " = " + totalStr;
        }

        return result;
    }

    private boolean isANumber(String str){
        try{
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException ex){
            return false;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = writeHeader(request, response);
        showForm(writer);
        writeFooter(writer);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstNumber = request.getParameter("firstNumber");
        String secondNumber = request.getParameter("secondNumber");

        PrintWriter writer = writeHeader(request, response);
        showForm(writer);
        writer.append("<p>" + add(firstNumber, secondNumber) + "</p>");
        writeFooter(writer);
    }
}
