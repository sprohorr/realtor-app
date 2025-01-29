<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
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
        <tr>
            <th>Address</th>
            <th>Number apartment</th>
            <th>Quantity rooms</th>
            <th>Area</th>
            <th>Price</th>
            <th>Description</th>
            <th>Status</th>
        </tr>
        <c:forEach var="apartment" items="${apartments}">
            <tr>
                <td><c:out value="${apartment.building.address}"/></td>
                <td><c:out value="${apartment.number}"/></td>
                <td><c:out value="${apartment.quantityRooms}"/></td>
                <td><c:out value="${apartment.area}"/></td>
                <td><c:out value="${apartment.price}"/></td>
                <td><c:out value="${apartment.description}"/></td>
                <td><c:set var="status">${apartment.status ? "Active" : "Close"}</c:set>
                    <c:out value="${status}"/>
                </td>
                <td><a href="/apartmentedit?apartment.id=${apartment.id}">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="/export?buildingId=${building.id}">Excel</a><br/>
    <a href="/import">Import from excel</a>
    <a href="/adminpage"><p align="center">Admin page</p></a>
</div>
</body>
</html>
