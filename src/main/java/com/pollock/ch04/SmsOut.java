package com.pollock.ch04;

import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import io.github.cdimascio.dotenv.Dotenv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;
import com.twilio.Twilio;
import com.twilio.*;

@WebServlet(name = "SmsOut", value = "/ch04/sms-out")
public class SmsOut extends HttpServlet {
    Dotenv dotenv = Dotenv.load();
    public final String TWILIO_PHONE = dotenv.get("TWILIO_PHONE_NUMBER");
    public final String TWILIO_SID = dotenv.get("TWILIO_ACCOUNT_SID");
    public final String TWILIO_TOKEN = dotenv.get("TWILIO_AUTH_TOKEN");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(TWILIO_PHONE);
        System.out.println(TWILIO_SID);

        request.getRequestDispatcher("./twilio.jsp").forward(request, response);
        //          Map<String, String> envMap = System.getenv();

          //version one
//        for(Map.Entry<String, String> entry : envMap.entrySet()){
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }

          //version two
//        envMap.forEach((k, v) -> System.out.println(k + " " + v));

        //version three
//        envMap.entrySet().forEach(System.out::println);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone = request.getParameter("phone");
        String message = request.getParameter("message");

        if(phone != null && !phone.equals("")){
            phone = phone.replaceAll("[^\\d.]", "");
        }
        else{
            request.setAttribute("errorMessage", "Phone number is required");
            request.setAttribute("smsError", true);

        }
        if(phone.length() != 10){
            // respond with an error message (Not a phone number)
            request.setAttribute("errorMessage", "Invalid phone number");
            request.setAttribute("smsError", true);
        } else if(message.length() == 0 || message == null){
            // Error, message required
            request.setAttribute("errorMessage", "Message is required");
            request.setAttribute("smsError", true);
        }
        else{ // Everything is Good!
            Twilio.init(TWILIO_SID, TWILIO_TOKEN);
            try{
                Message msg = Message.creator(
                        new PhoneNumber("+1" + phone),
                        new PhoneNumber(TWILIO_PHONE),
                        message
                ).create();

                request.setAttribute("smsError", false);
                System.out.println(msg.getSid());
            } catch (final ApiException ex) {
                System.out.println(ex.getMessage());
                request.setAttribute("errorMessage", ex.getMessage());
                request.setAttribute("smsError", true);
            }
        }
        request.getRequestDispatcher("./twilio.jsp").forward(request, response);
    }
}
