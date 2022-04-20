<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/include/header.jsp"/>
<!-- navbar -->

<div class="container">
    <h2 class="mt-5">Profile</h2>

    <% if(request.getAttribute("user") == null){ %>
        <p>Something went wrong. Try logging out and logging back in.</p>
    <% } else {%>
        <div class="form-group mb-2">
            <label>First Name</label>
            <p>${user.firstName}</p>
        </div>
        <div class="form-group mb-2">
            <label>Last Name</label>
            <p>${user.lastName}</p>
        </div>
        <div class="form-group mb-2">
            <label>Phone Number</label>
            <p>${user.phoneNumber}</p>
            <a class="btn btn-primary">Test phone number</a>
        </div>
        <div class="form-group mb-2">
            <label>Email Address</label>
            <p>${user.username}</p>
        </div>
    <% } %>
</div>

<jsp:include page="/WEB-INF/include/footer.jsp"/>
