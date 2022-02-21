package com.pollock.ch04;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.twilio.type.Twiml;
import io.github.cdimascio.dotenv.Dotenv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "VoiceOut", value = "/ch04/voice-out")
public class VoiceOut extends HttpServlet {
    Dotenv dotenv = Dotenv.load();
    public final String ACCOUNT_SID = dotenv.get("TWILIO_ACCOUNT_SID");
    public final String AUTH_TOKEN = dotenv.get("TWILIO_AUTH_TOKEN");
    public final String TWILIO_PHONE_NUMBER = dotenv.get("TWILIO_PHONE_NUMBER");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("./twilio.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone = request.getParameter("phone");
        String msg = request.getParameter("message");

        if(phone != null && !phone.equals("")) {
            String phoneNoChars = phone.replaceAll("[^\\d.]", "");
            request.setAttribute("callError", false);
            if(phoneNoChars.length() != 10) {
                // Error - invalid phone number (too short or too long)
                request.setAttribute("callError", true);
                request.setAttribute("callErrorMessage", "Invalid phone number");
            } else if(msg != null && msg.length() > 0){
                Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
                String twiml = ""
                        + "<Response>"
                        + "<Pause length=\"2\" />"
                        + "<Say voice=\"Polly.Joanna\">" + msg + "</Say>"
                        + "<Play loop=\"5\">https://demo.twilio.com/docs/classic.mp3</Play>"
                        + "</Response>";
                try {
                    Call call = Call.creator(
                            new PhoneNumber("+1" + phoneNoChars),
                            new PhoneNumber(TWILIO_PHONE_NUMBER),
                            new Twiml(twiml)
                    ).create();

                    System.out.println(call.getSid());
                } catch (Exception e) {
                    request.setAttribute("callError", true);
                    request.setAttribute("callErrorMessage", "Cannot make phone call right now. Try again later.");
                    System.err.println(e);
                }
            }
            else{
                request.setAttribute("callError", true);
                request.setAttribute("callErrorMessage", "Message required.");
            }
        } else {
            // Error - phone number missing
            request.setAttribute("callError", true);
            request.setAttribute("callError", true);
            request.setAttribute("callErrorMessage", "Phone number required.");
        }
        request.setAttribute("phone", phone);
        request.setAttribute("message", msg);
        request.getRequestDispatcher("./twilio.jsp").forward(request, response);
    }
}
