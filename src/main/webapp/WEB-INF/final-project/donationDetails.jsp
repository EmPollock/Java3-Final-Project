<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/include/finalHeader.jsp"/>
<jsp:include page="/WEB-INF/include/finalNavbar.jsp"/>

<div class="container">
    <br/>
    <br/>
    <c:choose>
        <c:when test="${error}">
            <p class="text-danger">ERROR: ${errorMsg}</p>
        </c:when>
        <c:otherwise>

            <div>
                <c:choose>
                    <c:when test="${donation.postName}">
                        <c:choose>
                            <c:when test="${fn:length(donation.donors) == 0}">
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
        </c:otherwise>
    </c:choose>

</div>

<jsp:include page="/WEB-INF/include/footer.jsp"/>
