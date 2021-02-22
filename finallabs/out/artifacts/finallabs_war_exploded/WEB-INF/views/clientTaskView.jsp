<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Client Task</title>
</head>
<body>

<jsp:include page="_menu.jsp"></jsp:include>

<h3>Client Task</h3>

<a href="${pageContext.request.contextPath}/createOrder">
    Create order<br> </a>

<a href="${pageContext.request.contextPath}/userOrders">
    View your orders<br> </a>

<a href="${pageContext.request.contextPath}/review">
    Check and write review<br> </a>

</body>
</html>