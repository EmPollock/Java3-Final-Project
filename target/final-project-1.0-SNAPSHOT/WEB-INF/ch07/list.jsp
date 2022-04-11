<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Contact List</title>
</head>
<body>
    <h1>Contact List</h1>
    <c:choose>
        <c:when test="${fn:length(contacts) == 0}">
            <p>The address book is empty.</p>
        </c:when>
        <c:when test="${fn:length(contacts) == 1}">
            <p>There is 1 contact in the address book.</p>
        </c:when>
        <c:otherwise>
            <p>There are ${fn:length(contacts)} contacts in the address book.</p>
        </c:otherwise>
    </c:choose>

    <c:if test="${fn:length(contacts) > 0}">
        <c:forEach var="user" items="${contacts}">
            <p>
                <strong>User Name:</strong> <c:out value="${user.username}"/> <br>
                <strong>Name:</strong> <c:out value="${user.lastName}"/>, <c:out value="${user.firstName}"/> <br>
                <strong>Phone Number:</strong> <c:out value="${user.phoneNumber}"/> <br>
                <c:if test="${user.birthday != null}">
                    <strong>Birthday:</strong> <c:out value="${user.birthday}" default="Not available"/> <br>
                </c:if>
                <strong>Last Updated:</strong> <c:out value="${user.lastUpdated}"/> <br>
                <strong>Balance:</strong> <c:out value="${user.balance}"/>
            </p>
        </c:forEach>
    </c:if>
</body>
</html>