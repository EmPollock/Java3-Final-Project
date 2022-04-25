<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/include/finalHeader.jsp"/>
<jsp:include page="/WEB-INF/include/finalNavbar.jsp"/>

<div class="container">
    <h2>Past Donations</h2>
    <div>
        <c:forEach var="donation" items="${donationList}">
            <div>
                <div>
                    <c:choose>
                        <c:when test="${donation.postName}">
                            <c:choose>
                                <c:when test="${donation.donors.size} == 1">
                                    <strong>Donors:</strong>
                                </c:when>
                                <c:otherwise>
                                    <strong>Donor:</strong>
                                </c:otherwise>
                            </c:choose>
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
                    <strong>Note:</strong>
                    <p>${donation.note}</p>
                </div>
            </div>
            <br>
            <br>
        </c:forEach>
    </div>

</div>

<jsp:include page="/WEB-INF/include/footer.jsp"/>