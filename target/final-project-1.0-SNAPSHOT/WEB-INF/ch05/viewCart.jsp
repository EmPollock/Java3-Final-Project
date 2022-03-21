<%@ page import="java.util.Hashtable" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Your Shopping Cart</title>
</head>
<body>
    <p><a href="shop">Browse Products</a></p>
    <h2>Your Shopping Cart</h2>
    <%
        Hashtable<Integer, String> products = (Hashtable<Integer, String>)request.getAttribute("products");
        Hashtable<Integer, Integer> cart = (Hashtable<Integer, Integer>)session.getAttribute("cart");
    %>
    <% if(cart == null || cart.isEmpty()) {%>
        <p>Your cart is empty</p>
    <% } else{ %>
        <ul>
            <% for(Integer id : cart.keySet()){%>
            <li><%=products.get(id)%> (Qty : <%=cart.get(id)%>) - <a href="shop?page=removeFromCart&itemId=<%=id%>">Remove from cart</a></li>
            <% } %>
        </ul>
        <p><a href="shop?page=emptyCart">Remove all items from cart</a></p>
    <% } %>
</body>
</html>
