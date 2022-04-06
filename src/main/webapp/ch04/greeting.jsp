<%--  This is a JSP Comment. It does not show up in the web page.--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- Scriptlet --%>
<%
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
    <h1>Hello ${fn:escapeXml(user)}!</h1>
    <form action="greeting" method="GET">
        <% if(true) {%>
        <label for="user">Enter your name:</label><br>
        <input type="text" name="user" id="user"><br><br>
        <% } else {%>
        <input type="hidden" name="user" value="${fn:escapeXml(user)}">
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
    <h1>${fn:escapeXml(user)}'s Favorite Fruits</h1>
    <ul>
        <% for(String fruit : favFruits) { %>
                <li> <%=fruit%> </li>
        <% }%>
    </ul>

    <h2>Input Statistics</h2>
    <ul>
        <li>Contains exactly "Kirkwood": ${fn:contains(user, "Kirkwood")}</li>
        <li>Contains "Kirkwood" any capitalization: ${fn:containsIgnoreCase(user, "Kirkwood")}</li>
        <li>To lowercase: ${fn:toLowerCase(user)}</li>
        <li>To uppercase: ${fn:toUpperCase(user)}</li>
        <li>Ends with "Kirkwood": ${fn:endsWith(fn:toLowerCase(user), "kirkwood")}</li>
        <li>Starting index of "Kirkwood": ${fn:indexOf(fn:toLowerCase(user), "kirkwood")}</li>
        <li>Length: ${fn:length(user)}</li>
        <li>"wood" changed to "land": ${fn:replace(fn:toLowerCase(user), "wood", "land")}</li>
        <li>Starts with "K": ${fn:startsWith(fn:toLowerCase(user), "k")}</li>
        <li>First 4 characters: ${fn:substring(user, 0, 4)}</li>
        <li>Characters after "Kirk": ${fn:substringAfter(fn:toLowerCase(user), "kirk")}</li>
        <li>Characters before "wood": ${fn:substringBefore(fn:toLowerCase(user), "wood")}</li>
        <li>White space removed from both ends: ${fn:trim(user)}</li>

        <c:set var="numWords" value="${fn:split(user, ' ')}" /> <!--Splits a string into an array of substrings-->

        <li>Number of words: ${fn:length(numWords)}</li> <!--Then finds the length of the array.-->
        <li>Words joined with a forward slash: ${fn:join(numWords, "/")}</li>
        <li>Fruit Multi-Parameter: ${fn:join(paramValues["fruit"], ", ")}</li> <!-- obtain all values from a query parameter -->
        <li>User parameter: ${param.user}</li> <!-- obtain a single query parameter -->
    </ul>

    <a href="greeting?user=${fn:escapeXml(user)}">Go back</a>
<% } %>
</body>
</html>
