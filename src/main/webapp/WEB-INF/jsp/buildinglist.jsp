<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <c:forEach items="${buildings}" var="building">
            <tr>
                <td><c:out value="Building id: ${building.id}"/></td>
                <td><c:out value="Address: ${building.address}"/></td>
                <td><c:out value="Quantity floor: ${building.floors}"/></td>
                <td><c:out value="Land area: ${building.landArea}"/></td>
                <td><c:out value="Building area: ${building.buildingArea}"/></td>
                <td><c:out value="Quantity apartments: ${building.quantityApartments}"/></td>
                <td><c:out value="Year building: ${building.year}"/></td>
                <td><c:set var="parking">${building.parking ? "Yes" : "No"}</c:set>
                    <c:out value="Parking: ${parking}"/></td>
                <td><c:out value="Description: ${building.description}"/></td>
                <td><a href="/buildingedit?building.id=${building.id}">Edit</a></td>
                <td><a href="/buildingapartmentlist?building=${building.id}">List apartments</a></td>
                    <%--                create apartment list in building controller--%>
            </tr>
        </c:forEach>
    </table>
</div>
<a href="/buildingadd"><p>Add new building</p></a>
</body>
</html>
