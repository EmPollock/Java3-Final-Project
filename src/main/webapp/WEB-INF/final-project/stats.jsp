<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/include/finalHeader.jsp"/>
<jsp:include page="/WEB-INF/include/finalNavbar.jsp"/>

<div class="container">
    <br/>
    <br/>
    <h2><c:out value="${viewUser.firstName}"/> <c:out value="${viewUser.lastName}"/> Stats</h2>

    <c:choose>
        <c:when test="${error}">
            <p>${errorMsg}</p>
        </c:when>
        <c:when test="${fn:length(userDonations) == 0}">
            <p>This user hasn't made any donations yet.</p>
        </c:when>
        <c:otherwise>
            <div>
                <p><strong>Number of Donations: </strong> <c:out value="${fn:length(userDonations)}"/></p>
                <p><strong>Total Amount Donated: </strong> <fmt:formatNumber value="${totalDonated}" type="currency" currencyCode="USD"/></p>
                <c:forEach var="donation" items="${userDonations}">
                    <div class="container">
                        <br/>
                        <br/>
                        <div>
                            <c:choose>
                                <c:when test="${fn:length(donation.donors) <= 1}">
                                    <strong>Donor:</strong>
                                </c:when>
                                <c:otherwise>
                                    <strong>Donors:</strong>
                                </c:otherwise>
                            </c:choose>
                            <p>
                                <c:forEach items="${donation.donors}" var="donor">
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <c:out value="${donor.givenName}"/> <c:out value="${donor.familyName}"/><br>
                                </c:forEach>
                            </p>
                        </div>

                        <div>
                            <strong>Date:</strong>
                            <fmt:formatDate value="${donation.newDateTimeProcessed}"/>
                        </div>

                        <div>
                            <strong>Amount:</strong>
                            <p><fmt:formatNumber type="currency" value="${donation.amount}"></fmt:formatNumber></p>
                        </div>
                        <div>
                            <strong>Apply to:</strong>
                            <c:out value="${donation.applyTo}"/>
                        </div>
                        <div>
                            <strong>Frequency:</strong>
                            <c:out value="${donation.frequency}"/>
                        </div>
                        <div>
                            <strong>Ending Date:</strong>
                            <fmt:formatDate value="${donation.newEnding}"/>
                        </div>
                        <div>
                            <strong>Note:</strong>
                            <p><c:out value="${donation.note}"/></p>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:otherwise>
    </c:choose>
</div>

<jsp:include page="/WEB-INF/include/footer.jsp"/>