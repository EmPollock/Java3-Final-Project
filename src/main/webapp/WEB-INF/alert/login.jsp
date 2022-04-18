<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/include/header.jsp"/>
<!-- navbar -->

<div class="container">
    <h2 class="mt-5">Login</h2>

    <form method="POST" action="login">
        <div class="form-group mb-2">
            <label for="email">Email</label>
            <input type="text" name="email" id="email" class="form-control">
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
    <a href="login?register" class="btn btn-secondary" >Register</a>
</div>

<jsp:include page="/WEB-INF/include/footer.jsp"/>
