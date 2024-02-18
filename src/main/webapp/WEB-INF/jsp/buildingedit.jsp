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
        <table align="center" border="2px">
            <tr>
                <td><input type="hidden" name="buildingId" value="${building.id}"/></td>
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
                    <p>Yes</p><form:radiobutton path="parking" value="1"/>
                    <p>No</p><form:radiobutton path="parking" value="0"/>
                </td>
            </tr>
            <tr>
                <td>
                    <button type="submit">Edit</button>
                </td>
            </tr>
        </table>
    </form:form>
    <a href="/adminpage"><p align="center">Admin page</p></a>
</div>
</body>
</html>
