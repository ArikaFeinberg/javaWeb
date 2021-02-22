<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>

<jsp:include page="_menu.jsp"></jsp:include>

<h3>Review</h3>

<form method="POST" action="${pageContext.request.contextPath}/review">
    <input type="hidden" name="redirectId" value="${param.redirectId}" />
    <table border="0">

        <tr>
            <td>Order name</td>
            <td><input type="text" name="orderName" value= "${order.orderName}" /> </td>
        </tr>
        <tr>
            <td>Review</td>
            <td><input type="text" name="review" value= "${order.review}" /> </td>
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