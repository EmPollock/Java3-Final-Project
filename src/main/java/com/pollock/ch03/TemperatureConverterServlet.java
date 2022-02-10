package com.pollock.ch03;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

@WebServlet(name = "TemperatureConverterServlet", value = "/temp-converter")
public class TemperatureConverterServlet extends HttpServlet {

    private PrintWriter writeHeader (HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();

        writer  .append("<!DOCTYPE HTML>\r\n")
                .append("<html>\r\n")
                .append("<head>\r\n")
                .append("<title>Temperature Converter Servlet</title>\r\n")
                .append("</head>\r\n")
                .append("<body>\r\n")
                .append("<h1>Convert a Temperature</h1>\r\n");

        return writer;
    }

    private void showForm(PrintWriter writer){
        writer  .append("<h2>Enter a number then press Convert!</h2>")
                .append("<form action=\"\" method=\"POST\">")
                .append("<label for=\"F\">Fahrenheit to Celsius</label>")
                .append("<input type=\"radio\" name=\"FOrC\" value=\"F\" id=\"F\" checked=\"checked\"> <br>")
                .append("<label for=\"C\">Celsius to Fahrenheit</label>")
                .append("<input type=\"radio\" name=\"FOrC\" value=\"C\" id=\"C\"><br>")
                .append("<input type=\"text\" name=\"temperature\" placeholder=\"Enter a temperature\">")
                .append("<input type=\"submit\" value=\"Convert\">")
                .append("</form>");
    }

    private void writeFooter (PrintWriter writer) throws IOException {
        writer  .append("</body>\r\n")
                .append("</html>");
        writer.close();
    }

    private boolean isANumber(String str){
        try{
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException ex){
            return false;
        }
    }

    private String convertTemp(String temperature, String FOrC){
        String result = "<strong>Error:</strong> Invalid input. Try again.";

        if (isANumber(temperature)){
            BigDecimal temp = new BigDecimal(temperature);
            BigDecimal convertedTemp;
            DecimalFormat df = new DecimalFormat("#, ##0.000");
            String formattedTemp = df.format(temp);

            if(FOrC.equals("F")){
                convertedTemp = temp.subtract(new BigDecimal(32.0)).multiply(new BigDecimal(5.0)).divide(new BigDecimal(9.0), new MathContext(6, RoundingMode.UP));
                result = "<strong>Result:</strong> " + formattedTemp + " degrees Fahrenheit = " + df.format(convertedTemp) + " degrees Celsius.";
            } else{
                convertedTemp = temp.multiply(new BigDecimal(9).divide(new BigDecimal(5), new MathContext(6, RoundingMode.UP))).add(new BigDecimal(32));
                result = "<strong>Result:</strong> " + formattedTemp + " degrees Celsius = " + df.format(convertedTemp) + " degrees Fahrenheit.";
            }
        }

        return result;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = writeHeader(request, response);
        showForm(writer);
        writeFooter(writer);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String temperature = request.getParameter("temperature");
        if (temperature.equals("")){
            temperature = "0";
        }
        String FOrC = request.getParameter("FOrC");

        PrintWriter writer = writeHeader(request, response);
        showForm(writer);
        writer.append("<p>" + convertTemp(temperature, FOrC) + "</p>");
        writeFooter(writer);
    }
}
