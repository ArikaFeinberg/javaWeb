<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Alter manager status</title>
</head>
<body>

<jsp:include page="_menu.jsp"></jsp:include>

<h3>Alter manager status</h3>

<form method="POST" action="${pageContext.request.contextPath}/managerStatus">
    <input type="hidden" name="redirectId" value="${param.redirectId}" />
    <table border="0">

        <tr>
            <td>Id of alternation position</td>
            <td><input type="number" name="id" value= "${order.id}" /> </td>
        </tr>
        <tr>
            <td>New value</td>
            <td><input type="text" name="mgrStatus" value= "${oder.mgrStatus}" /> </td>
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