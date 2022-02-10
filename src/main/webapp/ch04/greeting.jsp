<%--  This is a JSP Comment. It does not show up in the web page.--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- Declatration --%>
<%!
    private final String DEFAULT_USER = "Guest";
    int x= 1 + 2;
%>

<%-- Scriptlet --%>
<%
    String user = request.getParameter("user");
    if(user == null || user.equals("")){
        user = DEFAULT_USER;
    }

    String[] favFruits = request.getParameterValues("fruit");
%>
<!DOCTYPE html>
<html lang="en-US">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Greeting Page</title>
    <link href="../styles/main.css" rel="stylesheet">
</head>
<body>
<%
    if(favFruits == null) {
%>
    <!-- This is an HTML Comment. It shows up in the web page. -->
    <%-- Expression --%>
    <h1>Hello <%=user%>!</h1>
    <form action="" method="POST">
        <% if(user.equals(DEFAULT_USER)) {%>
        <label for="user">Enter your name:</label><br>
        <input type="text" name="user" id="user"><br><br>
        <% } else {%>
        <input type="hidden" name="user" value="<%=user%>">
        <% }%>

        <p>Select the fruits you like to eat:</p>
        <input type="checkbox" name="fruit" id="banana" value="Banana">
        <label for="banana">Banana</label><br>
        <input type="checkbox" name="fruit" id="apple" value="Apple">
        <label for="apple">Apple</label><br>
        <input type="checkbox" name="fruit" id="orange" value="Orange">
        <label for="orange">Orange</label><br>
        <input type="checkbox" name="fruit" id="guava" value="Guava">
        <label for="guava">Guava</label><br>
        <input type="checkbox" name="fruit" id="kiwi" value="Kiwi">
        <label for="kiwi">Kiwi</label><br><br>

        <input type="submit" value="Submit">
    </form>
<% } else {%>
    <h1><%=user%>'s Favorite Fruits</h1>
    <ul>
        <% for(String fruit : favFruits) { %>
                <li> <%=fruit%> </li>
        <% }%>
    </ul>
    <a href="greeting.jsp?user=<%=user%>">Go back</a>
<% } %>
</body>
</html>
