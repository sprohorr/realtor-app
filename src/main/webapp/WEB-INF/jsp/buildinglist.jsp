<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of buildings</title>
</head>
<body style="background-color: lavender">
<div>
    <h2 align="center">List of buildings</h2>
</div>
<div>
    <table border="2px" align="center">
        <tr>
            <th>Address</th>
            <th>Quantity floor</th>
            <th>Land area</th>
            <th>Building area</th>
            <th>Quantity apartments</th>
            <th>Year building</th>
            <th>Parking</th>
            <th>Description</th>
        </tr>
        <c:forEach items="${buildings}" var="building">
            <tr>
                <td><c:out value="${building.address}"/></td>
                <td><c:out value="${building.floors}"/></td>
                <td><c:out value="${building.landArea}"/></td>
                <td><c:out value="${building.buildingArea}"/></td>
                <td><c:out value="${building.quantityApartments}"/></td>
                <td><c:out value="${building.year}"/></td>
                <td><c:set var="parking">${building.parking ? "Yes" : "No"}</c:set>
                    <c:out value="${parking}"/></td>
                <td><c:out value="${building.description}"/></td>
                <td><a href="/buildingedit?buildingId=${building.id}">Edit</a></td>
                <td><a href="/buildingapartmentlist?buildingId=${building.id}">List apartments</a></td>
                <td><a href="/apartmentadd?buildingId=${building.id}">Add new apartments</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<a href="/buildingadd"><p>Add new building</p></a>
<a href="/adminpage"><p align="center">Admin page</p></a>
</body>
</html>
