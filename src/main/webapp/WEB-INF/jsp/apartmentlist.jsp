<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Apartments list</title>
</head>
<body style="background-color: lavender">
<div>
    <h2 align="center">List of apartments</h2>
</div>
<div>
    <table border="2px">
        <c:forEach var="apartment" items="${apartments}">
            <tr>
                <td><p>Address: ${apartment.building.address}</p></td>
                <td><p>Number apartment: ${apartment.number}</p></td>
                <td><p>Quantity rooms: ${apartment.quantityRooms}</p></td>
                <td><p>Area: ${apartment.area}</p></td>
                <td><p>Price: ${apartment.price}</p></td>
                <td><p>Description: ${apartment.description}</p></td>
                <td><p>Status: ${apartment.status}</p></td>
                <td><a href="/apartmentedit?apartment.id=${apartment.id}">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
