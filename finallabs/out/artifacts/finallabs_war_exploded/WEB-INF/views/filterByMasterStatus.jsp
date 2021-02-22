<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Filter by master status</title>
</head>
<body>

<jsp:include page="_menu.jsp"></jsp:include>

<h3>Filter by master status</h3>


<form method="POST" action="${pageContext.request.contextPath}/filterByMasterStatus">
    <input type="hidden" name="redirectId" value="${param.redirectId}" />
    <table border="0">
        <tr>
            <td>Input status</td>
            <td><input type="text" name="masterStatus" value= "${order.masterStatus}" /> </td>
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