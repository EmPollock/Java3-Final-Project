<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/include/finalHeader.jsp"/>
<jsp:include page="/WEB-INF/include/finalNavbar.jsp"/>

<div class="container">
    <br/>
    <br/>
    <h2>Thanks to everyone who has donated!</h2>
    <div>
        <c:forEach var="donation" items="${donationList}">
            <div>
                <div>
                    <c:choose>
                        <c:when test="${donation.postName}">
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
                        </c:when>
                        <c:otherwise>
                            <strong>Donor:</strong>
                            <p>The donor wishes to remain anonymous</p>
                        </c:otherwise>
                    </c:choose>
                </div>

                <div>
                    <strong>Date:</strong>
                    <fmt:formatDate value="${donation.newDateTimeProcessed}"/>
                    <br/>
                    <br/>
                </div>

                <div>
                    <strong>Amount:</strong>
                    <c:choose>
                        <c:when test="${donation.postAmount}">
                            <p><fmt:formatNumber type="currency" value="${donation.amount}"></fmt:formatNumber></p>
                        </c:when>
                        <c:otherwise>
                            <p>The donor wishes to keep their amount private</p>
                        </c:otherwise>
                    </c:choose>
                </div>

                <div>
                    <strong>Apply to:</strong>
                    <c:out value="${donation.applyTo}"/>
                </div>

                <div>
                    <strong>Note:</strong>
                    <p><c:out value="${donation.note}"/></p>
                </div>
                <a class="btn btn-primary" href="<c:url value="/donation"><c:param name="action" value="view"/> <c:param name="donationID" value="${donation.id}"/></c:url>">View Details</a>
            </div>
            <br>
            <br>
        </c:forEach>
    </div>

</div>

<jsp:include page="/WEB-INF/include/footer.jsp"/>