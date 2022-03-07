package com.pollock.support;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet(name = "TicketServlet", value = "/support/tickets", loadOnStartup = 1)
@MultipartConfig(
        fileSizeThreshold = 1_000_000, // 1MB
        maxFileSize = 5_000_000L // 5MB
)
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
                viewTicket(request, response);
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

        for(Part part : request.getParts()){
            if (part.getName().equals("file") && part != null && part.getSize() > 0){
                Attachment attachment = processAttachment(part);
                if(attachment != null){
                    ticket.addAttachment(attachment);
                }
            }
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
        String idString = request.getParameter("ticketId");
        Ticket ticket = getTicket(idString);
        request.setAttribute("ticketId", idString);
        request.setAttribute("ticket", ticket);
        request.getRequestDispatcher("/WEB-INF/support/viewTicket.jsp").forward(request, response);
    }

    private Ticket getTicket(String idStr){
        if(idStr == null || idStr.length() == 0){
            return null;
        }
        try{
            int id = Integer.parseInt(idStr);
            return ticketDB.get(id);
        } catch (NumberFormatException ex){
            return null;
        }
    }

    private Attachment processAttachment(Part part) throws IOException {
        Attachment attachment = new Attachment();

        try(InputStream inputStream = part.getInputStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream()){
            int read;
            final byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            attachment.setName(part.getSubmittedFileName());
            attachment.setContents(outputStream.toByteArray());
        }

        return attachment;
    }
}
