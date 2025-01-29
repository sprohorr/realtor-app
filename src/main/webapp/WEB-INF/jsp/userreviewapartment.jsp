<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Apartment review</title>
</head>
<body>
<div><h2 style="color: slateblue" align="center">Apartment list</h2></div>
<div>
    <table border="2px" align="center">
        <c:forEach var="apartment" items="${apartments.content}">
            <tr>
                <td><c:out value="Address: ${apartment.building.address}"/></td>
                <td><c:out value="Number apartment: ${apartment.number}"/></td>
                <td><c:out value="Quantity rooms: ${apartment.quantityRooms}"/></td>
                <td><c:out value="Area: ${apartment.area}"/></td>
                <td><c:out value="Price: ${apartment.price}"/></td>
                <td><c:out value="Description: ${apartment.description}"/></td>
                <td><c:set var="status">${apartment.status ? "Active" : "Close"}</c:set>
                    <c:out value="Status: ${status}"/>
                </td>
                <td><a href="/ordermake?apartmentId=${apartment.id}&userId=${user.id}">Make an order</a></td>
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
                    <a href="/userreviewapartment?page=${loop.index}">${loop.index + 1}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </div>
</div>
<div><a href="/logout">Log out</a></div>
</body>
</html>
