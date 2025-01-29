<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Apartments list</title>
</head>
<body style="background-color: lavender">
<div>
    <h2 align="center">List of apartments ${agent.name}</h2>
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
            <th>Active</th>
        </tr>
        <c:forEach var="apartment" items="${apartments.content}">
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
                <td><a href="/apartmentedit?apartmentId=${apartment.id}">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
    <div>
        <c:forEach begin="0" end="${apartments.totalPages-1}" varStatus="loop">
            <c:choose>
                <c:when test="${loop.index == currentPage}">
                    ${loop.index + 1}
                </c:when>
                <c:otherwise>
                    <a href="/apartmentlist?page=${loop.index}&agentId=${agent.id}">${loop.index + 1}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </div>
    <a href="/adminpage"><p align="center">Admin page</p></a>
</div>
</body>
</html>
