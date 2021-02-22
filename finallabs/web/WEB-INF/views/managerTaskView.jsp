<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manager Task</title>
</head>

<body>

<jsp:include page="_menu.jsp"></jsp:include>

<h3>Manager Task</h3>

<a href="${pageContext.request.contextPath}/viewAllUsers">
    User list<br>
</a>

<a href="${pageContext.request.contextPath}/createUser">
    Insert user<br>
</a>

<a href="${pageContext.request.contextPath}/viewAllOrders">
    Orders list<br>
</a>

<a href="${pageContext.request.contextPath}/masterName">
    Master name alternation<br>
</a>
<a href="${pageContext.request.contextPath}/managerStatus">
    Manager status alternation<br>
</a>

<a href="${pageContext.request.contextPath}/price">
    Price alternation<br>
</a>

<a href="${pageContext.request.contextPath}/sortByPrice">
    Price sort <br>
</a>

<a href="${pageContext.request.contextPath}/sortByDate">
    Date sort <br>
</a>

<a href="${pageContext.request.contextPath}/sortByStatus">
    Manager status sort <br>
</a>

<a href="${pageContext.request.contextPath}/filterByMgrStatus">
    Filter by manager status <br>
</a>

<a href="${pageContext.request.contextPath}/filterByMasterStatus">
    Filter by master status <br>
</a>

<a href="${pageContext.request.contextPath}/alterCount">
    Alter user count <br>
</a>


</body>
</html>