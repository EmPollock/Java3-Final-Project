<%@ page import="com.pollock.support.Ticket" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //@SuppressWarnings("unchecked")
    Map<Integer, Ticket> ticketData = (Map<Integer, Ticket>)request.getAttribute("ticketData");
    int numTickets = ticketData.size();
%>
<jsp:include page="/WEB-INF/include/header.jsp"/>
<jsp:include page="/WEB-INF/include/navbar.jsp"/>
    <div class="container">
        <h1 class="mt-5">Support Tickets</h1>
        <p class="lead">There <%= numTickets == 1 ? "is" : "are" %> <%=numTickets%> ticket<%= numTickets == 1 ? "" : "s" %> in the system</p>
        <%
            if(ticketData.size() > 0) {
        %>
            <ul>
                <%
                    for(int id : ticketData.keySet()){
                        Ticket ticket = ticketData.get(id);
                %>
                <li><a href="tickets?action=view&ticketId=<%= id %>">Ticket #<%=id%> - From: <%=ticket.getCustomerName()%></a></li>
                <%
                    }
                %>
            </ul>
        <%
            }
        %>
    </div>
<jsp:include page="/WEB-INF/include/footer.jsp"/>