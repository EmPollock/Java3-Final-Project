<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/include/header.jsp"/>
<!-- navbar -->

<div class="container">
    <h2>Register</h2>
    <form action="" method="POST">
        <label>Username</label> <br>
        <input class="most-width" type="text" name="username">

        <label>Email</label> <br>
        <input class="most-width" type="email" name="email">


        <label>Password</label> <br>
        <input class="most-width" type="password" name="password1">

        <label>Confirm Password</label> <br>
        <input class="most-width" type="password" name="password2">

        <input class="most-width" id="submit" type="submit" name="submit" value="Submit">
    </form>
</div>

<jsp:include page="/WEB-INF/include/footer.jsp"/>