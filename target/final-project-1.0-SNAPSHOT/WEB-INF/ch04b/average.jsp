<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../include/header.jsp"/>
<main class="flex-shrink-0">
    <div class="container">
        <h1 class="mt-5">Average Calculator</h1>
        <p class="lead">Enter three numbers and click Calculate to find the average</p>
        <form method="POST" action="average">
            <div class="row">
                <div class="form-group mb-3 col">
                    <label for="num1">Number 1</label>
                    <input class="form-control" type="number" name="num1" id="num1">
                </div>
                <div class="form-group mb-3 col">
                    <label for="num2">Number 2</label>
                    <input class="form-control" type="number" name="num2" id="num2">
                </div>
                <div class="form-group mb-3 col">
                    <label for="num3">Number 3</label>
                    <input class="form-control" type="number" name="num3" id="num3">
                </div>
            </div>
            <input class="btn btn-secondary text-light mb-3" type="submit" value="Calculate">
        </form>
    </div>
</main>
<jsp:include page="../include/footer.jsp"/>
