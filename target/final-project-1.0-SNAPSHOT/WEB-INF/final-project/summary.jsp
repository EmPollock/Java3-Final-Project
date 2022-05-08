<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/include/finalHeader.jsp"/>
<jsp:include page="/WEB-INF/include/finalNavbar.jsp"/>

<div class="container">
    <br/>
    <br/>
    <h2>Summary</h2>
    <div>
        <p><strong>Number of users: </strong> <c:out value="${fn:length(users)}"/></p>
        <p><strong>Donation total: </strong> <fmt:formatNumber value="${donationTotal}" type="currency" currencyCode="USD" /></p>
        <p><strong>Average amount per donation: </strong> <fmt:formatNumber value="${averagePerDono}" type="currency" currencyCode="USD" /></p>
        <p><strong>Number of donations today: </strong> <fmt:formatNumber value="${donationsToday}"/></p>
        <p><strong>Average number of donations per user:</strong> <fmt:formatNumber value="${averageUserDonos}"/></p>

        <br/>
        <c:forEach var="donor" items="${users}">
            <div class="border-info">
                <p><strong>Name: </strong>${donor.firstName} ${donor.lastName}</p>
                <p><strong>Email: </strong>${donor.email}</p>
                <p><strong>Birthday: </strong><fmt:formatDate value="${donor.newBirthday}" dateStyle="medium" /></p>
                <a href="<c:url value="/donation">
                        <c:param name="action" value="stats"/>
                        <c:param name="user" value="${donor.email}"/>
                </c:url>" class="btn btn-primary">Stats</a>
                <br/>
                <br/>
            </div>
        </c:forEach>

    </div>
</div>

<jsp:include page="/WEB-INF/include/footer.jsp"/>