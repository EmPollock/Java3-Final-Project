<%@ page import="com.pollock.ch06.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>User Profile ~ ${fullName}</title>
</head>
<body>
    <header></header>

    <main>
        <ul>
            <li><strong>User ID</strong> ${user.userID}</li> <!-- jsp calls the getUserID method. if that's not there it doesn't work -->
            <li><strong>Username</strong> ${user["username"]}</li> <!-- works the same as line above -->
            <li><strong>First Name</strong> ${user.firstName}</li>
            <li><strong>Last Name</strong> ${user.lastName}</li>
            <%
                User user = (User)request.getAttribute("user");
                if(user != null && (user.getPermissions().get("admin") || user.getPermissions().get("super-admin"))){
            %>
            <li><strong>Likes Pizza</strong> ${user.likesPizza}</li>
            <% } %>
            <li><strong>Permissions</strong>
                <ul>
                    <li><strong>Active</strong> ${user.permissions.active}</li>
                    <li><strong>Admin</strong> ${user["permissions"]["admin"]}</li>
                    <li><strong>Super Admin</strong> ${user.permissions["super-admin"]}</li>
                </ul>
            </li>
        </ul>

        <h2>Array data</h2>
        <p>The first user is ${usersArr[0].firstName} ${usersArr[0].lastName}</p>
        <p>The second user is ${usersArr[1].firstName} ${usersArr[1].lastName}</p>

        <p>The second vowel is ${vowels[1]}</p>

        <p>The attribute 'a' is set on the ${a} object</p> <!-- request has higher precedence than session -->
        <p>The attribute 'a' is also set on the ${sessionScope.a} object</p>
    </main>

    <footer>Copyright &copy; ${currentYear}</footer>
</body>
</html>
