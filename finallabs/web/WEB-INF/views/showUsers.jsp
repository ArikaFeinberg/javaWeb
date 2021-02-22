<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Show all users</title>
</head>

<body>

<jsp:include page="_menu.jsp"></jsp:include>

<h3>Show all users</h3>
<table>
    <tr>
        <th>Username</th>
        <th>Password</th>
        <th>Role</th>
        <th>Count</th>
    </tr>
    <c:forEach items = "${userList}" var = "userList">
        <tr>
            <td>${userList.userName}</td>
            <td>${userList.password}</td>
            <td>${userList.roles}</td>
            <td>${userList.count}</td>
        </tr>

    </c:forEach>


</table>
</body>
</html>