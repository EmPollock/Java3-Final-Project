<header>
    <!-- Fixed navbar -->
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-info">
        <div class="container-fluid">
            <a class="navbar-brand">Songs!</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav me-auto mb-2 mb-md-0">
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="<c:url value="/songs"><c:param name="go" value="view"></c:param></c:url>">Song List</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/songs"><c:param name="go" value="list"></c:param></c:url>">My Play List</a>
                    </li>
                </ul>
                <ul class="navbar-nav mb-auto me-3">
                    <c:choose>
                        <c:when test="${username != null}">
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value="/songs"><c:param name="go" value="logout"></c:param></c:url>">Logout</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value="/login"/>">Login</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </nav>
</header>