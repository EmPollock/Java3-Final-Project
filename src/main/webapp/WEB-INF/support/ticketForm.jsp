<%--
  Created by IntelliJ IDEA.
  User: Pollock
  Date: 3/2/2022
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/include/header.jsp"/>
<jsp:include page="/WEB-INF/include/navbar.jsp"/>
    <div class="container">
        <h1 class="mt-5">Create a Ticket</h1>
        <c:if test="${ticketSubmitted}">
            <div class="alert alert-success">
                <p>Thank you, we have received your trouble ticket.</p>
            </div>
        </c:if>
        <form class="mt-5" method="POST" action="<c:url value="/support/tickets">" enctype="multipart/form-data">
            <div class="form-group mb-2">
                <label for="name">Your Name</label>
                <input type="text" name="name" id="name" class="form-control"
                    <c:if test="${not empty username}">
                       value="${username}"
                    </c:if>
                >
            </div>
            <div class="form-group mb-2">
                <label for="subject">Subject</label>
                <input type="text" name="subject" id="subject" class="form-control">
            </div>
            <div class="form-group mb-2">
                <label for="message">Message</label>
                <textarea name="message" id="message" class="form-control" rows="5" cols="30"></textarea>
            </div>
            <div class="form-group mb-2">
                <label for="file">Attachments</label>
                <input type="file" name="file" id="file" multiple class="form-control">
            </div>
            <input type="submit" value="Send" class="btn btn-secondary mb-5">
        </form>
    </div>
<jsp:include page="/WEB-INF/include/footer.jsp"/>
