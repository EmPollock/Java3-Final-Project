<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Teach Yourself SQL</title>
    <link href="styles/main2.css">
</head>
<body>
    <h2>Products</h2>
    <form action="tysql.jsp" method="GET">
        Price less than:
        <select name="price">
            <option value="5">5</option>
            <option value="10">10</option>
            <option value="20">20</option>
        </select>
        <input type="submit" value="go"/>
    </form>
    <sql:query dataSource="${dbConn}" var="result">
        SELECT *
        FROM products
        WHERE prod_price < ?
        ;
        <sql:param value="${param.price}"/>
    </sql:query>
    <table>
        <thead>
            <tr>
                <th>prod_id</th>
                <th>vend_id</th>
                <th>prod_name</th>
                <th>prod_price</th>
                <th>prod_description</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="row" items="${result.rows}">
                <tr>
                    <td><c:out value="${row.prod_id}"/></td>
                    <td><c:out value="${row.vend_id}"/></td>
                    <td><c:out value="${row.prod_name}"/></td>
                    <td><c:out value="${row.prod_price}"/></td>
                    <td><c:out value="${row.prod_desc}"/></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
