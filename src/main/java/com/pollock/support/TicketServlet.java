package com.pollock.support;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet(name = "TicketServlet", value = "/support/tickets", loadOnStartup = 1)
public class TicketServlet extends HttpServlet {
    // Create tickets
    // View ticket
    // Download file
    // View all tickets
    // /support/tickets?action=create
    // /support/tickets?action=view&ticketId=1
    // /support/tickets?action=download&id=1
    // does not have to be "action", could be anything else

    private Map<Integer, Ticket> ticketDB;
    private volatile int TICKET_ID = 0;

    @Override
    public void init() throws ServletException {
        ticketDB = new LinkedHashMap<>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "list";
        }
        switch(action){
            case "create":
                showTicketForm(request, response);
                break;
            case "view":

                break;
            case "download":

                break;
            case "list":
            default:
                listTickets(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("error", false);
        try {
            createTicket(request, response);
        }
        catch(Exception ex){
            request.setAttribute("error", true);
            request.setAttribute("errorMsg", ex.getMessage());
        }
    }

    private void listTickets(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("ticketData", ticketDB);
        request.getRequestDispatcher("/WEB-INF/support/listTickets.jsp").forward(request, response);
    }

    private void showTicketForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/WEB-INF/support/ticketForm.jsp").forward(request, response);
    }

    private void createTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Ticket ticket = new Ticket();
        try {
            ticket.setCustomerName(request.getParameter("name"));
            ticket.setSubject(request.getParameter("subject"));
            ticket.setBody(request.getParameter("message"));
        }
        catch(Exception ex){
           throw ex;
        }

        int id;
        synchronized (this){
            id = ++this.TICKET_ID;
        }

        // add id and ticket to ticketData
        this.ticketDB.put(id, ticket);

        // go to detail page for new ticket
        response.sendRedirect("tickets?action=view&ticketId=" + id);
    }

    private void viewTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
    }
}
