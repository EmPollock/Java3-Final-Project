<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/include/songHeader.jsp"/>
<jsp:include page="/WEB-INF/include/songNavbar.jsp"/>
<main class="flex-shrink-0">
    <div class="container">
        <h2 class="mt-5">Login</h2>

        <c:if test="${loggedOut}">
            <div class="alert alert-success">
                <p>You have been logged out.</p>
            </div>
        </c:if>
        <form method="POST" action="<c:url value="/login"></c:url>">
            <div class="form-group mb-2">
                <label for="username">Username</label>
                <input type="text" name="username" id="username" class="form-control">
            </div>
            <div class="form-group mb-2">
                <label for="password">Password</label>
                <input type="password" name="password" id="password" class="form-control">
            </div>

            <c:if test="${loginFailed}">
                <div class="alert alert-danger" role="alert">
                    Error: <c:out value="${errorMsg}"/>
                </div>
            </c:if>

            <input type="submit" value="Login" class="btn btn-secondary mb-5">
        </form>
    </div>

<jsp:include page="/WEB-INF/include/footer.jsp"/>
