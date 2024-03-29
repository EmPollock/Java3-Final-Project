<header>
    <!-- Fixed navbar -->
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-info">
        <div class="container-fluid">
            <a class="navbar-brand">Animal Shelter</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav me-auto mb-2 mb-md-0">
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="
                            <c:url value="/donation">
                                <c:param name="action" value="list"/>
                            </c:url>">Thank you!</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/donation"><c:param name="action" value="donate"/></c:url>">Donate</a>
                    </li>

                    <c:if test="${user != null}">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/donation"><c:param name="action" value="my-donations"/></c:url>">My Past Donations</a>
                        </li>
                    </c:if>
                    <c:if test="${user != null && user.permissions[\"admin\"]}">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/donation"><c:param name="action" value="summary"/></c:url>">Summary</a>
                        </li>
                    </c:if>
                </ul>
                <ul class="navbar-nav">
                    <c:choose>
                        <c:when test="${user != null}">
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value="/donation"><c:param name="action" value="logout"/></c:url>">Logout</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value="/donation/login"/>">Login</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </nav>
</header>
<main class="flex-shrink-0">
