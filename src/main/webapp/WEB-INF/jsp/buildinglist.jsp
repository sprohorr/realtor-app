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
  <table border="2px">
    <c:forEach items="${buildings}" var="building">
      <tr>
        <td><p>Address: ${building.address}</p></td>
        <td><p>Quantity floor: ${building.floors}</p></td>
        <td><p>Land area: ${building.landArea}</p></td>
        <td><p>Building area: ${building.buildingArea}</p></td>
        <td><p>Quantity apartments: ${building.quantityApartments}</p></td>
        <td><p>Year building: ${building.year}</p></td>
        <td><p>Parking: ${building.parking}</p></td>
        <td><p>Description: ${building.description}</p></td>
        <td><a href="/buildingedit?building.id=${building.id}">Edit</a></td>
        <td><a href="/apartmentlist?building.id=${building.id}">List apartments</a></td>
      </tr>
    </c:forEach>
  </table>
</div>
<a href="/buildingadd"><p>Add new building</p></a>
</body>
</html>
