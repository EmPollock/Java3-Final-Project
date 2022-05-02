<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Directory</title>
    <link href="<c:url value="/styles/main2.css" />" rel="stylesheet">
</head>
<body>
<div class="container">
    <h2>Directory</h2>

    <div class="people">
        <c:forEach items="${people}" var="person" begin="${begin}" end="${end}">
            <div class="person">
                <img src="${person.picture}" alt="<c:out value="${person.firstName}" />&nbsp;<c:out value="${person.lastName}" />">
                <p><c:out value="${person.firstName}" />&nbsp;<c:out value="${person.lastName}" /></p>
            </div>
        </c:forEach>
    </div>

    <div class="pagination">
        <a href="<c:url value="/ch07/directory"><c:param name="page" value ="1" /></c:url>">|&lt;</a>
        <a href="<c:url value="/ch07/directory"><c:param name="page" value ="${currentPage - 1 < 1 ? 1 : currentPage - 1}" /></c:url>">&lt</a>
        <c:forEach var="i" begin="${beginPage}" end="${endPage}">
            <a <c:if test="${currentPage == i}">class="active"</c:if>
                    <c:choose>
                        <c:when test="${i <= maxPages}">
                            href="<c:url value="/ch07/directory"><c:param name="page" value="${i}" /></c:url>">${i}
                        </c:when>
                        <c:otherwise>
                            href="#">&nbsp;
                        </c:otherwise>
                    </c:choose>
            </a>
        </c:forEach>
        <a href="<c:url value="/ch07/directory"><c:param name="page" value ="${currentPage + 1 > maxPages ? maxPages : currentPage + 1}" /></c:url>">&gt</a>
        <a href="<c:url value="/ch07/directory"><c:param name="page" value ="${maxPages}" /></c:url>">&gt;|</a>
    </div>
</div>
</body>
</html>
