<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/include/header.jsp"/>
<!-- navbar -->

<div class="container">
    <h2>Register</h2>

    <%
        Boolean success = (Boolean)request.getAttribute("success");
        if(success != null && success){
    %>
    <div class="alert alert-success">
        <p>Thank you for registering!</p>
    </div>
    <%  }  else {%>
    <form method="POST" action="login?register">
        <div class="form-group mb-2">
            <label>First Name</label>
            <input class="form-control" type="text" name="firstName">
        </div>
        <div class="form-group mb-2">
            <label>Last Name</label>
            <input class="form-control" type="text" name="lastName">
        </div>
        <div class="form-group mb-2">
            <label>Phone Number</label>
            <input class="form-control" type="text" name="phone" placeholder="(Ex. 345-687-9012)">
        </div>
        <div class="form-group mb-2">
            <label>Email Address</label>
            <input class="form-control" type="text" name="email">
        </div>
        <div class="form-group mb-2">
            <label for="password1">Password</label>
            <input type="password" name="password1" id="password1" class="form-control">
        </div>
        <div class="form-group mb-2">
            <label for="password2">Confirm Password</label>
            <input type="password" name="password2" id="password2" class="form-control">
        </div>

        <%
            Boolean registerFailed = (Boolean)request.getAttribute("registerFailed");
            if(registerFailed == null) registerFailed = false;
            if(registerFailed) {
        %>
        <div class="alert alert-danger" role="alert">
            Error: <%= request.getAttribute("errorMsg") %>
        </div>
        <% } %>

        <input type="submit" value="Register" class="btn btn-secondary mb-5">
    </form>
    <% } %>
</div>

<jsp:include page="/WEB-INF/include/footer.jsp"/>