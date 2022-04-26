<%@ page import="com.pollock.support.Ticket" %>
<%@ page import="com.pollock.support.Attachment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/include/header.jsp"/>
<jsp:include page="/WEB-INF/include/navbar.jsp"/>

<div class="container">
    <c:choose>
        <c:when test="${empty ticket}">
            <h1 class="mt-5">The ticket you requested cannot be found.</h1>
        </c:when>
        <c:otherwise>
            <h1 class="mt-5">Ticket #${ticketId}</h1>
            <dl class="row">
                <dt class="col-sm-4 col-md-3">Customer Name</dt>
                <dd class="col-sm-8 col-md-9">
                    <p>${fn:escapeXml(ticket.customerName)}</p>
                </dd>
            </dl>
            <dl class="row">
                <dt class="col-sm-4 col-md-3">Subject</dt>
                <dd class="col-sm-8 col-md-9">
                    <p><c:out value="${ticket.subject}"/></p>
                </dd>
            </dl>
            <dl class="row">
                <dt class="col-sm-4 col-md-3">Message</dt>
                <dd class="col-sm-8 col-md-9">
                    <p>${ticket.body}</p>
                </dd>
            </dl>
            <c:if test="${ticket.numberOfAttachments > 0}">
            <dl class="row">
                <dt class="col-sm-4 col-md-3">Attachment</dt>
                <dd class="col-sm-8 col-md-9">
                    <ul>
                        <c:forEach items="${ticket.attachments}" var="attachment">
                            <li>
                                <a href="<c:url value="/support/tickets">
                                        <c:param name="action" value="download" />
                                        <c:param name="ticketId" value="${ticketId}" />
                                        <c:param name="attachment" value="${attachment.name}" />
                                    </c:url>">${attachment.name}
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </dd>
            </dl>
            </c:if>
        </c:otherwise>
    </c:choose>
</div>

<jsp:include page="/WEB-INF/include/footer.jsp"/>
