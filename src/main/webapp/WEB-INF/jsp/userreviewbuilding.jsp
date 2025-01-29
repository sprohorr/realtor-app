<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Building review</title>
</head>
<body>
<div><h2 style="color: slateblue" align="center">Building list</h2></div>
<div>
    <table border="2px" align="center">
        <c:forEach items="${buildings}" var="building">
            <tr>
                <td><c:out value="Address: ${building.address}"/></td>
                <td><c:out value="Quantity floor: ${building.floors}"/></td>
                <td><c:out value="Land area: ${building.landArea}"/></td>
                <td><c:out value="Building area: ${building.buildingArea}"/></td>
                <td><c:out value="Quantity apartments: ${building.quantityApartments}"/></td>
                <td><c:out value="Year building: ${building.year}"/></td>
                <td><c:set var="parking">${building.parking ? "Yes" : "No"}</c:set>
                    <c:out value="Parking: ${parking}"/></td>
                <td><c:out value="Description: ${building.description}"/></td>
                <td><a href="/userreviewapartment?buildingId=${building.id}">List apartments</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<div><a href="/logout">Log out</a></div>
</body>
</html>
