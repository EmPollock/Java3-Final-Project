package com.pollock.ch07;

import com.pollock.ch06.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

@WebServlet(name = "ListServlet", value = "/ListServlet")
public class ListServlet extends HttpServlet {

    private static final SortedSet<User> contacts = new TreeSet<>();

    @Override
    public void init() throws ServletException {
        contacts.add(new User(1, "amelia.phillips@example.com", "Amelia", "Phillips", "9758082076", null, LocalDateTime.of(2017, Month.JUNE, 15, 8, 39).atZone(ZoneId.of("Asia/Tokyo")).toInstant(), new BigDecimal("99999.99")));
        contacts.add(new User(2, "victoria.alexander@example.com", "Victoria", "Alexander", "7060399938", LocalDate.of(1994, 7, 11), LocalDateTime.of(2022, Month.FEBRUARY, 6, 18, 59).atZone(ZoneId.of("America/Chicago")).toInstant(), new BigDecimal("9876.54")));
        contacts.add(new User(3, "frances.marshall@example.com", "Frances", "Marshall", "3579771475", LocalDate.of(1997, 8, 1), LocalDateTime.of(2021, Month.SEPTEMBER, 8, 19, 51).atZone(ZoneId.of("Europe/Paris")).toInstant(), new BigDecimal("1234567.89")));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("contacts", contacts);
        request.getRequestDispatcher("/WEB-INF/ch07/list.jsp").forward(request, response);
    }
}
