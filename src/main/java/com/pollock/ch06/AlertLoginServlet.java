package com.pollock.ch06;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

@WebServlet(name = "AlertLoginServlet", value = "/alert/login")
public class AlertLoginServlet extends HttpServlet {
    private static Hashtable<User, String> users = new Hashtable<>();

    @Override
    public void init() throws ServletException {
        User user1 = (new User());
        user1.setUsername("tess-data@kirkwood.edu");
        user1.setFirstName("Tess");
        user1.setLastName("Data");

        Map<String, Boolean> permissions = new Hashtable<>();
        permissions.put("active", true);
        permissions.put("admin", true);
        permissions.put("super-admin", false);
        user1.setPermissions(permissions);
        users.put(user1, "newuser");

        User user2 = (new User());
        user1.setUsername("emma-pollock@student.kirkwood.edu");
        user1.setFirstName("Emma");
        user1.setLastName("Pollock");
        user1.setPhoneNumber("319 440 6888");
        Map<String, Boolean> permissions2 = new Hashtable<>();
        permissions2.put("active", true);
        permissions2.put("admin", false);
        permissions2.put("super-admin", false);
        user2.setPermissions(permissions2);
        users.put(user2, "P@ssw0rd");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("users") != null){
            users = (Hashtable<User, String>) session.getAttribute("users");
        }
        else{
            session.setAttribute("users", users);
        }

        if(request.getParameter("logout")  != null){
            session.removeAttribute("email");
            request.setAttribute("loggedOut", true);
        }
        if(request.getParameter("register") != null){
            request.getRequestDispatcher("/WEB-INF/alert/register.jsp").forward(request, response);
        }
        if(session.getAttribute("email") != null){
            response.sendRedirect("kirkwood");
            return;
        }


        request.getRequestDispatcher("/WEB-INF/alert/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if(request.getParameter("register") != null){
            request.setAttribute("registerFailed", false);
            password = request.getParameter("password1");
            String confirmPassword = request.getParameter("password2");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String phone = request.getParameter("phone");
            if(firstName == null || firstName.length() == 0){
                request.setAttribute("registerFailed", true);
                request.setAttribute("errorMsg", "Please enter your first name.");
                request.getRequestDispatcher("/WEB-INF/alert/register.jsp").forward(request, response);
            }
            else if(lastName == null || lastName.length() == 0){
                request.setAttribute("registerFailed", true);
                request.setAttribute("errorMsg", "Please enter your last name.");
                request.getRequestDispatcher("/WEB-INF/alert/register.jsp").forward(request, response);
            }
            else if(phone == null || phone.length() == 0){
                request.setAttribute("registerFailed", true);
                request.setAttribute("errorMsg", "Please enter your phone number.");
                request.getRequestDispatcher("/WEB-INF/alert/register.jsp").forward(request, response);
            }
            else if(!phone.matches("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$")){
                request.setAttribute("registerFailed", true);
                request.setAttribute("errorMsg", "Please enter a valid phone number.");
                request.getRequestDispatcher("/WEB-INF/alert/register.jsp").forward(request, response);
            }
            else if(email == null || email.length() == 0 || users.contains(email)){
                request.setAttribute("registerFailed", true);
                request.setAttribute("errorMsg", "Please use a different email address.");
                request.getRequestDispatcher("/WEB-INF/alert/register.jsp").forward(request, response);
            }
            else if(password == null || password.length() == 0){
                request.setAttribute("registerFailed", true);
                request.setAttribute("errorMsg", "Enter a password");
                request.getRequestDispatcher("/WEB-INF/alert/register.jsp").forward(request, response);
            }
            else if(!password.equals(confirmPassword)) {
                request.setAttribute("registerFailed", true);
                request.setAttribute("errorMsg", "The passwords don't match.");
                request.getRequestDispatcher("/WEB-INF/alert/register.jsp").forward(request, response);
            }
            else{
                User user = new User();
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setPhoneNumber(phone);
                user.setUsername(email);

                Map<String, Boolean> permissions = new Hashtable<>();
                permissions.put("active", true);
                permissions.put("admin", false);
                permissions.put("super-admin", false);

                user.setPermissions(permissions);
                users.put(user, password);

                HttpSession session = request.getSession();
                session.setAttribute("users", users);
                session.setAttribute("username", email);
                request.changeSessionId();
                request.setAttribute("success", true);
                request.getRequestDispatcher("/WEB-INF/alert/register.jsp").forward(request, response);
            }
        }
        else{
            request.setAttribute("loginFailed", false);
            if(email == null || email.length() == 0 || password == null || password.length() == 0){
                request.setAttribute("loginFailed", true);
                request.setAttribute("errorMsg", "login attempt failed");
                request.getRequestDispatcher("/WEB-INF/alert/login.jsp").forward(request, response);
            }
            else{
                boolean auth = false;
                for(User user : users.keySet()){
                    if(user.getUsername().equals(email)){
                        if(users.get(user).equals(password)) {
                            auth = true;
                        }
                        break;
                    }
                }
                if(!auth){
                    request.setAttribute("loginFailed", true);
                    request.setAttribute("errorMsg", "login attempt failed");
                    request.getRequestDispatcher("/WEB-INF/alert/login.jsp").forward(request, response);
                } else{
                    HttpSession session = request.getSession();
                    session.setAttribute("username", email);
                    request.changeSessionId();
                    session.setAttribute("users", users);
                    response.sendRedirect("kirkwood");
                }
            }
        }
    }
}
