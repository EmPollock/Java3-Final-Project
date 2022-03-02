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
<main class="flex-shrink-0">
    <div class="container">
        <h1 class="mt-5">Support Tickets</h1>
        <p class="lead">There <%= numTickets == 1 ? "is" : "are" %> <%=numTickets%> ticket<%= numTickets == 1 ? "" : "s" %> in the system</p>
    </div>
</main>
<jsp:include page="/WEB-INF/include/footer.jsp"/>