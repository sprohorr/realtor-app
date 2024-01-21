<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Edit building</title>
</head>
<body style="background-color: lavender">
<div><h2 align="center">Edit building</h2></div>
<div>
  <form:form action="${pageContext.request.contextPath}/buildingedit" method="post" modelAttribute="building">
    <table>
      <tr>
        <td><input type="hidden" name="building.id" value="${building.id}"/></td>
      </tr>
      <tr>
        <td><form:input path="address"/>Address</td>
      </tr>
      <tr>
        <td><form:input path="floors"/>Quantity floors</td>
      </tr>
      <tr>
        <td><form:input path="landArea"/>Land area</td>
      </tr>
      <tr>
        <td><form:input path="buildingArea"/>Building Area</td>
      </tr>
      <tr>
        <td><form:input path="quantityApartments"/>Quantity apartments</td>
      </tr>
      <tr>
        <td><form:input path="year"/>Year build</td>
      </tr>
      <tr>
        <td><form:input path="description"/>Description</td>
      </tr>
      <tr>
        <td><p>Parking</p>
          <p>Yes</p><form:checkbox path="parking" value="1"/>
          <p>No</p><form:checkbox path="parking" value="0"/>
        </td>
      </tr>
    </table>
    <button type="submit">Edit</button>
  </form:form>
</div>
</body>
</html>
