<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
</head>
<body style="background-color: lavender">
<div style="color: darkgray"><h2 align="center">Order ${user.login}</h2></div>
<div>
    <h2 align="center">${text}</h2>
    <table align="center" border="2px">
        <c:forEach var="order" items="${orders}">
            <tr>
                <td><c:out value="Status: ${order.status.name}"/></td>
                <td><c:out value="Address: ${order.apartment.building.address}"/></td>
                <td><c:out value="Opening date: ${order.openTime}"/></td>
                <td><c:out value="Closing date: ${order.closeTime}"/></td>
                <td><c:out value="Price:${order.apartment.price} "/></td>
                <td><a href="#">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="/userpage?userId=${user.id}">User page</a>
</div>
</body>
</html>
