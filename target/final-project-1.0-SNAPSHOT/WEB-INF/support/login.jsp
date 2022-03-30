
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/include/header.jsp"/>
<jsp:include page="/WEB-INF/include/navbar.jsp"/>

<div class="container">
    <h2 class="mt-5">Login</h2>
    <%
        Boolean ticketSubmitted = (Boolean)request.getAttribute("ticketSubmitted");
        if(ticketSubmitted != null && ticketSubmitted){
    %>
    <div class="alert alert-success">
        <p>Thank you, we have received your trouble ticket.</p>
    </div>
    <%  }  %>
    <form method="POST" action="login">
        <div class="form-group mb-2">
            <label for="username">Username</label>
            <input type="text" name="username" id="username" class="form-control">
        </div>
        <div class="form-group mb-2">
            <label for="password">Password</label>
            <input type="password" name="password" id="password" class="form-control">
        </div>

        <%
            Boolean loginFailed = (Boolean)request.getAttribute("loginFailed");
            if(loginFailed == null) loginFailed = false;
            if(loginFailed) {
        %>
        <div class="alert alert-danger" role="alert">
            Error: <%= request.getAttribute("errorMsg") %>
        </div>
        <% } %>

        <input type="submit" value="Login" class="btn btn-secondary mb-5">
    </form>
</div>

<jsp:include page="/WEB-INF/include/footer.jsp"/>
