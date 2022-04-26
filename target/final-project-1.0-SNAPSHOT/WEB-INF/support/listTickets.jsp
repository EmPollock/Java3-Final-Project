<%@ taglib prefix="url" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <c:choose>
            <c:when test="${fn:length(ticketData) == 0}">
                There are no tickets in the system.
            </c:when>
            <c:when test="${fn:length(ticketData) == 1}">
                There is 1 ticket in the system.
            </c:when>
            <c:otherwise>
                There are ${fn:length(ticketData)} tickets in the system.
            </c:otherwise>
        </c:choose>

        <c:if test="${fn:length(ticketData) > 0}">
            <ul>
                <c:forEach items="${ticketData}" var="entry">
                    <li><a href="
                        <c:url value="/support/tickets">
                            <c:param name="action" value="view" />
                            <c:param name="ticketId" value="${entry.key}" />
                        </c:url>">Ticket #${entry.key}</a> -
                                    From: ${entry.value.customerName}
                    </li>
                </c:forEach>
            </ul>
        </c:if>
    </div>
<jsp:include page="/WEB-INF/include/footer.jsp"/>