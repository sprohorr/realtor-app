<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Apartments in this building</title>
</head>
<body style="background-color: lavender">
<div>
    <h2 align="center">List of apartments in this building</h2>
</div>
<div>
    <table border="2px" align="center">
        <c:forEach var="apartment" items="${apartments}">
            <tr>
                <td><c:out value="Address: ${apartment.building.address}"/></td>
                <td><c:out value="Number apartment: ${apartment.number}"/></td>
                <td><c:out value="Quantity rooms: ${apartment.quantityRooms}"/></td>
                <td><c:out value="Area: ${apartment.area}"/></td>
                <td><c:out value="Price: ${apartment.price}"/></td>
                <td><c:out value="Description: ${apartment.description}"/></td>
                <td><c:set var="status">${apartment.status ? "Open" : "Close"}</c:set>
                    <c:out value="Status: ${status}"/>
                </td>
                <td><a href="/apartmentedit?apartment.id=${apartment.id}">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
