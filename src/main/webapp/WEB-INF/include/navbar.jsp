<header>
    <!-- Fixed navbar -->
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-info">
        <div class="container-fluid">
            <a class="navbar-brand">Chapter 4b</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav me-auto mb-2 mb-md-0">
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="<c:url value="/ch04b/average"/>">Average Calculator</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/support/tickets"><c:param name="action" value="create"></c:param></c:url>">Create Ticket</a>
                    </li>

                    <c:if test="${not empty username}">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/support/tickets"/>">View Tickets</a>
                        </li>
                    </c:if>
                </ul>
                <ul class="navbar-nav mb-auto me-3">
                    <c:choose>
                        <c:when test="${not empty username}">
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value="/support/login"><c:param name="logout"></c:param></c:url>">Logout</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value="/support/login"/>">Login</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </nav>
</header>
<main class="flex-shrink-0">

