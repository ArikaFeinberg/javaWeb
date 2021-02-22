<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Filter by manager status</title>
</head>
<body>

<jsp:include page="_menu.jsp"></jsp:include>

<h3>Filter by manager status</h3>


<form method="POST" action="${pageContext.request.contextPath}/filterByMgrStatus">
    <input type="hidden" name="redirectId" value="${param.redirectId}" />
    <table border="0">
        <tr>
            <td>Input status</td>
            <td><input type="text" name="mgrStatus" value= "${order.mgrStatus}" /> </td>
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