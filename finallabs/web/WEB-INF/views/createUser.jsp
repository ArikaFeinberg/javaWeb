<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert user</title>
</head>
<body>

<jsp:include page="_menu.jsp"></jsp:include>

<h3>Create new user</h3>


<form method="POST" action="${pageContext.request.contextPath}/createUser">
    <input type="hidden" name="redirectId" value="${param.redirectId}" />
    <table border="0">
        <tr>
            <td>User Name</td>
            <td><input type="text" name="userName" value= "${user.userName}" /> </td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" value= "${user.password}" /> </td>
        </tr>

        <tr>
            <td>Role</td>
            <td><input type = "text" name="roles" value="${user.roles}" /></td>
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