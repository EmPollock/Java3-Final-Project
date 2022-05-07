<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/include/finalHeader.jsp"/>
<jsp:include page="/WEB-INF/include/finalNavbar.jsp"/>

<div class="container">
    <br/>
    <br/>
    <c:if test="${success != null}">
        <c:choose>
            <c:when test="${success}">
                <p class="text-success">Thank you for donating!</p>
            </c:when>
            <c:otherwise>
                <p class="text-danger">${errorMsg}</p>
            </c:otherwise>
        </c:choose>
    </c:if>
    <form method="POST" action="<c:url value="/donation"></c:url>" class="table text-black">
        <div class="form-group">
            <h4>Donors</h4>
                <div class="control-group row">
                    <div class="col">
                        <label for="givenName1">First Name</label>
                        <input type="text" name="givenName1" id="givenName1" class="form-control border-info text-black">
                        <c:if test="${givenName1Error != null && givenName1Error != \"\"}">
                            <p class="text-danger">${givenName1Error}</p>
                        </c:if>
                    </div>
                    <div class="col">
                        <label for="familyName1">Last Name</label>
                        <input type="text" name="familyName1" id="familyName1" class="form-control border-info text-black">
                        <c:if test="${familyName1Error != null && familyName1Error != \"\"}">
                            <p class="text-danger">${familyName1Error}</p>
                        </c:if>
                    </div>
                    <div class="col">
                        <label for="email1">Email Address</label>
                        <input type="text" name="email1" id="email1" class="form-control border-info text-black">
                        <c:if test="${email1Error != null && email1Error != \"\"}">
                            <p class="text-danger">${email1Error}</p>
                        </c:if>
                    </div>
                </div>
                <div class="control-group row">
                    <div class="col">
                        <label for="givenName2">First Name</label>
                        <input type="text" name="givenName2" id="givenName2" class="form-control border-info text-black">
                        <c:if test="${givenName2Error != null && givenName2Error != \"\"}">
                            <p class="text-danger">${givenName2Error}</p>
                        </c:if>
                    </div>
                    <div class="col">
                        <label for="familyName2">Last Name</label>
                        <input type="text" name="familyName2" id="familyName2" class="form-control border-info text-black">
                        <c:if test="${familyName2Error != null && familyName2Error != \"\"}">
                            <p class="text-danger">${familyName2Error}</p>
                        </c:if>
                    </div>
                    <div class="col">
                        <label for="email2">Email Address</label>
                        <input type="text" name="email2" id="email2" class="form-control border-info text-black">
                        <c:if test="${email2Error != null && email2Error != \"\"}">
                            <p class="text-danger">${email2Error}</p>
                        </c:if>
                    </div>
                </div>
                <div class="control-group row">
                    <div class="col">
                        <label for="givenName3">First Name</label>
                        <input type="text" name="givenName3" id="givenName3" class="form-control border-info text-black">
                        <c:if test="${givenName3Error != null && givenName3Error != \"\"}">
                            <p class="text-danger">${givenName3Error}</p>
                        </c:if>
                    </div>
                    <div class="col">
                        <label for="familyName3">Last Name</label>
                        <input type="text" name="familyName3" id="familyName3" class="form-control border-info text-black">
                        <c:if test="${familyName3Error != null && familyName3Error != \"\"}">
                            <p class="text-danger">${familyName3Error}</p>
                        </c:if>
                    </div>
                    <div class="col">
                        <label for="email3">Email Address</label>
                        <input type="text" name="email3" id="email3" class="form-control border-info text-black">
                        <c:if test="${email3Error != null && email3Error != \"\"}">
                            <p class="text-danger">${email3Error}</p>
                        </c:if>
                    </div>
                </div>
                <div class="control-group row">
                    <div class="col">
                        <label for="postName">Show my name in public post</label>
                        <input type="checkbox" name="postName" id="postName" value="true" checked>
                    </div>
                    <div class="col"></div>
                    <div class="col"></div>
                </div>
            <hr>
            <h4>Donation</h4>
                <div class="control-group row">
                    <div class="col">
                        <label for="amount">Amount (USD)</label>
                        <input type="text" name="amount" id="amount" class="form-control border-info text-black">
                        <c:if test="${amountError != null && amountError != \"\"}">
                            <p class="text-danger">${amountError}</p>
                        </c:if>
                    </div>
                    <div class="col">
                        <label for="frequency">Frequency</label>
                        <br/>
                        <select name="frequency" id="frequency" class="form-control border-info text-black">
                            <option value="Once">Once</option>
                            <option value="Yearly">Yearly</option>
                            <option value="Monthly">Monthly</option>
                            <option value="Weekly">Weekly</option>
                            <option value="Daily">Daily</option>
                        </select>
                        <c:if test="${frequencyError != null && frequencyError != \"\"}">
                            <p class="text-danger">${frequencyError}</p>
                        </c:if>
                    </div>
                    <div class="col">
                        <label for="endingDate">Until</label>
                        <br/>
                        <input type="date" name="endingDate" id="endingDate" class="form-control border-info text-black">
                        <c:if test="${endingDateError != null && endingDateError != \"\"}">
                            <p class="text-danger">${endingDateError}</p>
                        </c:if>
                    </div>
                </div>
                <div class="control-group row">
                    <div class="col">
                        <label for="postAmount">Show the amount in public post</label>
                        <input type="checkbox" name="postAmount" id="postAmount" value="true" checked>
                    </div>
                    <div class="col"></div>
                    <div class="col"></div>
                </div>
                <div class="control-group row">
                    <div class="col">
                        <label for="applyTo">Apply To</label>
                        <br/>
                        <select name="applyTo" id="applyTo" class="form-control border-info text-black">
                            <option value="Odds and Ends">Odds and Ends</option>
                            <option value="Puppies">Puppies</option>
                            <option value="Kittens">Kittens</option>
                            <option value="Cats">Cats</option>
                            <option value="Birds">Birds</option>
                            <option value="Old Dogs">Old Dogs</option>
                            <option value="Unusual Animals">Unusual Animals</option>
                            <option value="Medical Care">Medical Care</option>
                            <option value="Kibbles and Bits">Kibbles and Bits</option>
                        </select>
                        <c:if test="${applyToError != null && applyToError != \"\"}">
                            <p class="text-danger">${applyToError}</p>
                        </c:if>
                    </div>
                </div>
                <div class="control-group row">
                    <label for="note">Note</label>
                    <textarea name="note" id="note" class="form-control border-info text-black"></textarea>
                    <c:if test="${noteError != null && noteError != \"\"}">
                        <p class="text-danger">${noteError}</p>
                    </c:if>
                </div>
        </div>
        <br/>
        <input type="submit" class="btn-primary">
    </form>
</div>

<jsp:include page="/WEB-INF/include/footer.jsp"/>
