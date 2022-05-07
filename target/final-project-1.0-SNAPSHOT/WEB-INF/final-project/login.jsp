<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/include/finalHeader.jsp"/>
<jsp:include page="/WEB-INF/include/finalNavbar.jsp"/>

<div class="container">
    <h2 class="mt-5">Login</h2>
    <form method="POST" action="login">
        <div class="form-group mb-2">
            <label for="email">Email</label>
            <input type="text" name="email" id="email" class="form-control border-info text-black">
        </div>
        <div class="form-group mb-2">
            <label for="password">Password</label>
            <input type="password" name="password" id="password" class="form-control border-info text-black">
        </div>

        <c:if test="${loginFailed}">
            <div class="alert alert-danger" role="alert">
                Error: <%= request.getAttribute("errorMsg") %>
            </div>
        </c:if>

        <input type="submit" value="Login" class="btn btn-primary mb-5">
    </form>
</div>

<jsp:include page="/WEB-INF/include/footer.jsp"/>
