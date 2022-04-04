<%@ page import="com.pollock.support.Ticket" %>
<%@ page import="com.pollock.support.Attachment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/include/header.jsp"/>
<jsp:include page="/WEB-INF/include/navbar.jsp"/>

<%
    Ticket ticket = (Ticket) request.getAttribute("ticket");
%>

<div class="container">
    <%
        if(ticket == null){
    %>
        <h1 class="mt-5">The ticket you requested cannot be found.</h1>
    <%
        } else {
    %>
        <h1 class="mt-5">Ticket #${ticketId}</h1>
        <dl class="row">
            <dt class="col-sm-4 col-md-3">Customer Name</dt>
            <dd class="col-sm-8 col-md-9">
                <p>${ticket.customerName}</p>
            </dd>
        </dl>
        <dl class="row">
            <dt class="col-sm-4 col-md-3">Subject</dt>
            <dd class="col-sm-8 col-md-9">
                <p>${ticket.subject}</p>
            </dd>
        </dl>
        <dl class="row">
            <dt class="col-sm-4 col-md-3">Message</dt>
            <dd class="col-sm-8 col-md-9">
                <p>${ticket.body}</p>
            </dd>
        </dl>
        <%
            if(ticket.getNumberOfAttachments() > 0){
        %>
        <dl class="row">
            <dt class="col-sm-4 col-md-3">Attachment</dt>
            <dd class="col-sm-8 col-md-9">
                <ul>
                <% for(Attachment attachment : ticket.getAttachments()){%>
                    <li>
                        <a href="tickets?action=download&ticketId=${ticketID}&attachment=<%=attachment.getName()%>">
                        <%=attachment.getName()%></a>
                    </li>
                <% } %>
                </ul>
            </dd>
        </dl>
        <%  } %>
    <%
        }
    %>
</div>

<jsp:include page="/WEB-INF/include/footer.jsp"/>
