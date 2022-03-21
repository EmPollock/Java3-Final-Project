<%@ page import="java.util.Map" %>
<%@ page import="java.util.Hashtable" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- !-TAB generates basic html w/ doctype, meta tags, and other useful stuff -->
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Browse our Products</title>
</head>
<body>
    <p><a href="shop?page=viewCart">View Cart</a></p>
    <h2>Browse our Products</h2>
    <p>Select an item to add to your cart</p>

    <%
       Map<Integer, String> products = (Map<Integer, String>)request.getAttribute("products");
    %>
    <ul>
        <% for(int id : products.keySet()) {%>
        <li><a href="shop?page=addToCart&itemId=<%=id%>"><%=products.get(id)%></a></li>
        <% }%>
    </ul>

</body>
</html>
