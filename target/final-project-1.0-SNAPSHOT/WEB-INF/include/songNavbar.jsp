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
                        <a class="nav-link" aria-current="page" href="songs?go=view">Song List</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="songs?go=list">My Play List</a>
                    </li>
                </ul>
                <ul class="navbar-nav mb-auto me-3">
                    <%
                        if(session.getAttribute("username") != null){
                    %>
                    <li class="nav-item">
                        <a class="nav-link" href="songs?go=logout">Logout</a>
                    </li>
                    <% } else {%>
                    <li class="nav-item">
                        <a class="nav-link" href="login">Login</a>
                    </li>
                    <% } %>
                </ul>
            </div>
        </div>
    </nav>
</header>