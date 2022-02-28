<%@ page import="com.pollock.ch04b.AverageModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Boolean error = (Boolean)request.getAttribute("error");
    String errorMsg = (String)request.getAttribute("errorMsg");
    AverageModel average = (AverageModel)request.getAttribute("average");
    String num1 = (String)request.getAttribute("num1");
    String num2 = (String)request.getAttribute("num2");
    String num3 = (String)request.getAttribute("num3");
    if(num1 == null){
        num1 = "";
    }
    if(num2 == null){
        num2 = "";
    }
    if(num3 == null){
        num3 = "";
    }
%>
<jsp:include page="../include/header.jsp"/>
<main class="flex-shrink-0">
    <div class="container">
        <h1 class="mt-5">Average Calculator</h1>
        <p class="lead">Enter three numbers and click Calculate to find the average</p>

        <form method="POST" action="average">
            <div class="row">
                <div class="form-group mb-3 col">
                    <label for="num1">Number 1</label>
                    <input class="form-control" type="text" name="num1" id="num1" value="<%=num1%>">
                </div>
                <div class="form-group mb-3 col">
                    <label for="num2">Number 2</label>
                    <input class="form-control" type="text" name="num2" id="num2" value="<%=num2%>">
                </div>
                <div class="form-group mb-3 col">
                    <label for="num3">Number 3</label>
                    <input class="form-control" type="text" name="num3" id="num3" value="<%=num3%>">
                </div>
            </div>
            <input class="btn btn-secondary text-light mb-3" type="submit" value="Calculate">
        </form>
        <% if(error != null && error){ %>
                <div class="alert alert-danger">
                    Error: <%=errorMsg%>
                </div>
        <% }else{ %>
                <div class="alert alert-success">
                    Result: <%=average%>
                </div>
        <% } %>
    </div>
</main>
<jsp:include page="../include/footer.jsp"/>
