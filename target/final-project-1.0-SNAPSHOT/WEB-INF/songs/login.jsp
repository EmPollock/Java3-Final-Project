<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en" class="h-100">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Songs</title>

    <!-- CSS only -->
    <link href="../styles/bootstrap.css" rel="stylesheet">
    <link href="../styles/main.css" rel="stylesheet">

    <style>
        main > .container{
            padding: 60px 15px 0;
        }
    </style>


    <!-- Custom styles for this template -->
    <link href="sticky-footer-navbar.css" rel="stylesheet">
</head>
<body class="d-flex flex-column h-100">
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
                        <a class="nav-link" aria-current="page" href="../songs?go=view">Song List</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../songs?go=list">My Play List</a>
                    </li>
                </ul>
                <ul class="navbar-nav mb-auto me-3">
                    <%
                        if(session.getAttribute("username") != null){
                    %>
                    <li class="nav-item">
                        <a class="nav-link" href="../songs?go=logout">Logout</a>
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
<main class="flex-shrink-0">
    <div class="container">
        <h2 class="mt-5">Login</h2>
        <%
            Boolean loggedOut = (Boolean)request.getAttribute("loggedOut");
            if(loggedOut != null && loggedOut){
        %>
        <div class="alert alert-success">
            <p>You have been logged out.</p>
        </div>
        <%  }  %>
        <form method="POST" action="login">
            <div class="form-group mb-2">
                <label for="username">Username</label>
                <input type="text" name="username" id="username" class="form-control">
            </div>
            <div class="form-group mb-2">
                <label for="password">Password</label>
                <input type="password" name="password" id="password" class="form-control">
            </div>

            <%
                Boolean loginFailed = (Boolean)request.getAttribute("loginFailed");
                if(loginFailed == null) loginFailed = false;
                if(loginFailed) {
            %>
            <div class="alert alert-danger" role="alert">
                Error: <%= request.getAttribute("errorMsg") %>
            </div>
            <% } %>

            <input type="submit" value="Login" class="btn btn-secondary mb-5">
        </form>
    </div>

<jsp:include page="/WEB-INF/include/footer.jsp"/>
