<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title><fmt:message key="title.browser"/></title>
</head>
<body>
    <h1><fmt:message key="title.page"/></h1>
    <c:choose>
        <c:when test="${fn:length(contacts) == 0}">
            <p><fmt:message key="contact-message.zero"/></p>
        </c:when>
        <c:when test="${fn:length(contacts) == 1}">
            <p><fmt:message key="contact-message.one"/></p>
        </c:when>
        <c:otherwise>
            <p><fmt:message key="contact-message.many"><fmt:param value="${fn:length(contacts)}"/></fmt:message></p>
        </c:otherwise>
    </c:choose>

    <c:if test="${fn:length(contacts) > 0}">
        <c:forEach var="user" items="${contacts}">
            <p>
                <strong><fmt:message key="label.userID"/>:</strong> <c:out value="${user.userID}"/> <br>
                <strong><fmt:message key="label.username"/>:</strong> <c:out value="${user.username}"/> <br>
                <strong><fmt:message key="label.name"/>:</strong> <c:out value="${user.lastName}"/>, <c:out value="${user.firstName}"/> <br>
                <strong><fmt:message key="label.phone"/>:</strong> <c:out value="${user.phoneNumber}"/> <br>
                <c:if test="${user.birthday != null}">
                    <strong><fmt:message key="label.birthday"/>:</strong> <fmt:formatDate value="${user.birthdayDate}" type="date" dateStyle="medium"/> <br>
                </c:if>
                <strong><fmt:message key="label.lastUpdated"/>:</strong> <fmt:formatDate value="${user.newLastUpdatedDate}" type="both" dateStyle="medium" timeStyle="short"/> <br>
                <strong><fmt:message key="label.balance"/>:</strong> <fmt:formatNumber value="${user.balance}" type="currency" currencyCode="USD"/>
            </p>
        </c:forEach>
    </c:if>

    <fmt:formatNumber type="number" value="12345.6789" maxFractionDigits="3"/> <br>
    <fmt:formatNumber type="percent" value=".6789" maxFractionDigits="2"/>
</body>
</html>