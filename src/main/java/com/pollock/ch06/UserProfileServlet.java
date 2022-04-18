package com.pollock.ch06;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@WebServlet(name = "UserProfileServlet", value = "/user/profile")
public class UserProfileServlet extends HttpServlet {
    private final List<User> users = new ArrayList<>();
    private final User[] usersArr = new User[2];

    @Override
    public void init() throws ServletException {
        User user1 = (new User());
        user1.setUsername("tess@company.com");
        user1.setFirstName("Tess");
        user1.setLastName("Data");

        Map<String, Boolean> permissions = new Hashtable<>();
        permissions.put("active", true);
        permissions.put("admin", true);
        permissions.put("super-admin", false);
        user1.setPermissions(permissions);
        users.add(user1);
        usersArr[0] = user1;

        User user2 = (new User());
        user1.setUsername("sample@example.com");
        user1.setFirstName("Sam");
        user1.setLastName("Ple");
        Map<String, Boolean> permissions2 = new Hashtable<>();
        permissions2.put("active", true);
        permissions2.put("admin", false);
        permissions2.put("super-admin", false);
        user2.setPermissions(permissions2);
        usersArr[1] = user2;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LocalDateTime today = LocalDateTime.now();
        String dayOfWeek = today.getDayOfWeek().toString();
        int currentYear = today.getYear();

        request.setAttribute("usersArr", usersArr);
        request.setAttribute("usersList", users);
        request.setAttribute("user", usersArr[0]);
        request.setAttribute("today", today);
        request.setAttribute("dayOfWeek", dayOfWeek);
        request.setAttribute("currentYear", currentYear);
        request.setAttribute("fullName", usersArr[0].getFirstName() + " " + usersArr[0].getLastName());

        request.setAttribute("a", "request");
        HttpSession session = request.getSession();
        session.setAttribute("a", "session");

        User newUser = new User();
        session.setAttribute("user2", newUser);

        List<Character> vowels = new ArrayList<>();
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        request.setAttribute("vowels", vowels);

        request.getRequestDispatcher("/WEB-INF/ch06/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
