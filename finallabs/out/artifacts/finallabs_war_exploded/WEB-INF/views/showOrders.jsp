<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Show all orders</title>
</head>

<body>

<jsp:include page="_menu.jsp"></jsp:include>

<h3>Show all orders</h3>
<table>
    <tr>
        <th>id</th>
        <th>Client name</th>
        <th>Order name</th>
        <th>Master name</th>
        <th>Master status</th>
        <th>Manager status</th>
        <th>Price</th>
        <th>Order date</th>
        <th>Review</th>
    </tr>
    <c:forEach items = "${orderList}" var = "orderList">
        <tr>
            <td>${orderList.id}</td>
            <td>${orderList.clientName}</td>
            <td>${orderList.orderName}</td>
            <td>${orderList.masterName}</td>
            <td>${orderList.masterStatus}</td>
            <td>${orderList.mgrStatus}</td>
            <td>${orderList.price}</td>
            <td>${orderList.date}</td>
            <td>${orderList.review}</td>
        </tr>

    </c:forEach>


</table>
</body>
</html>