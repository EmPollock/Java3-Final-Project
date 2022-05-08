<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/include/finalHeader.jsp"/>
<jsp:include page="/WEB-INF/include/finalNavbar.jsp"/>

<div class="container">
    <br/>
    <br/>
    <h2>Your Donations</h2>
    <c:choose>
        <c:when test="${fn:length(donationList) == 0}">
            <p>There are no donations linked with your account.</p>
        </c:when>
        <c:otherwise>
            <div>
                <c:forEach var="donation" items="${donationList}">
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
                            <br/>
                        </div>

                        <div>
                            <strong>Amount:</strong>
                            <p><fmt:formatNumber type="currency" value="${donation.amount}"></fmt:formatNumber></p>
                        </div>
                        <br/>
                        <div>
                            <strong>Apply to:</strong>
                            <c:out value="${donation.applyTo}"/>
                        </div>
                        <br/>
                        <div>
                            <strong>Frequency:</strong>
                            <c:out value="${donation.frequency}"/>
                        </div>
                        <br/>
                        <div>
                            <strong>Ending Date:</strong>
                            <fmt:formatDate value="${donation.newEnding}"/>
                        </div>
                        <br/>
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