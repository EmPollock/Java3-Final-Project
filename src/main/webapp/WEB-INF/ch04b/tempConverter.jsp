<%@ page import="com.pollock.ch04b.Temperature" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
        Boolean error = (Boolean)request.getAttribute("error");
        String errorMsg = (String)request.getAttribute("errorMsg");

        String inputTemp = (String)request.getAttribute("temp");
        Temperature t = (Temperature) request.getAttribute("t");

        if(inputTemp == null){
            inputTemp = "";
        }
%>

<jsp:include page="../include/header.jsp"/>
<main class="flex-shrink-0">
    <div class="container">
        <h1 class="mt-5">Convert a Temperature</h1>
        <p class="lead">Enter a number then press Convert!</p>

        <form method="POST" action="temp-converter">
            <div class="row">
                <div class="form-group mb-3 col">
                    <label for="F">Fahrenheit to Celsius</label>
                    <input type="radio" name="FOrC" value="F" id="F">
                </div>
                <div class="form-group mb-3 col">
                    <label for="C">Celsius to Fahrenheit</label>
                    <input type="radio" name="FOrC" value="C" id="C">
                </div>
                <div class="form-group col"></div>
            </div>
            <div class="row">
                <div class="mb-3 col">
                    <input type="text" name="temp" placeholder="Enter a temperature">
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <input class="btn btn-info text-light mb-3" type="submit" value="Convert">
                </div>
            </div>
        </form>
        <% if(error != null && error){ %>
        <div class="alert alert-danger">
            Error: <%=errorMsg%>
        </div>
        <% }else if(t != null){ %>
        <div class="alert alert-success">
            Result: <%=t%>
        </div>
        <% } %>
    </div>
</main>
<jsp:include page="../include/footer.jsp"/>
