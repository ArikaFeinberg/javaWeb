<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Master Task</title>
</head>

<body>

<jsp:include page="_menu.jsp"></jsp:include>

<h3>Master Task</h3>

<a href="${pageContext.request.contextPath}/viewAllOrders">
    Orders list<br>
</a>

<a href="${pageContext.request.contextPath}/masterStatus">
    Alter master status<br>
</a>

</body>
</html>