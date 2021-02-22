<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert order</title>
</head>
<body>

<jsp:include page="_menu.jsp"></jsp:include>

<h3>Create new order</h3>

<form method="POST" action="${pageContext.request.contextPath}/createOrder">
    <input type="hidden" name="redirectId" value="${param.redirectId}" />
    <table border="0">
        <tr>
            <td>Order Name</td>
            <td><input type="text" name="orderName" value= "${order.orderName}" /> </td>
        </tr>
        <tr>
            <td>Day</td>
            <td><input type="number" name="day" value= "${day}" /> </td>
        </tr>

        <tr>
            <td>Month</td>
            <td><input type = "number" name="month" value="${month}" /></td>
        </tr>

        <tr>
            <td>Year</td>
            <td><input type = "number" name="year" value="${year}" /></td>
        </tr>

        <tr>
            <td colspan ="2">
                <input type="submit" value= "Submit" />
            </td>
        </tr>
    </table>
</form>


</body>
</html>