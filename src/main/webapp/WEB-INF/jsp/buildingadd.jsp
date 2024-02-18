<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="button" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new building</title>
</head>
<body style="background-color: lavender">
<div>
    <h2 align="center">Add new building</h2>
</div>
<div>
    <form:form action="/buildingadd" method="post" modelAttribute="building">
        <table align="center" border="2px">
            <tr>
                <td><form:input path="address"/>Address
                    <br/>
                    <form:errors cssStyle="color: red" path="address"/>
                </td>
            </tr>
            <tr>
                <td><form:input path="floors"/>Quantity floors
                    <br/>
                    <form:errors cssStyle="color: red" path="floors"/>
                </td>
            </tr>
            <tr>
                <td><form:input path="landArea"/>Land area
                    <br/>
                    <form:errors cssStyle="color: red" path="landArea"/>
                </td>
            </tr>
            <tr>
                <td><form:input path="buildingArea"/>Building Area
                    <br/>
                    <form:errors cssStyle="color: red" path="buildingArea"/>
                </td>
            </tr>
            <tr>
                <td><form:input path="quantityApartments"/>Quantity apartments
                    <br/>
                    <form:errors cssStyle="color: red" path="quantityApartments"/>
                </td>
            </tr>
            <tr>
                <td><form:input path="year"/>Year build
                    <br/>
                    <form:errors cssStyle="color: red" path="year"/>
                </td>
            </tr>
            <tr>
                <td><form:input path="description"/>Description</td>
            </tr>
            <tr>
                <td>Parking:
                    Yes<form:radiobutton path="parking" value="1"/>
                    No<form:radiobutton path="parking" value="0"/>
                </td>
            </tr>
            <tr>
                <td>
                    <button type="submit">Add</button>
                </td>
            </tr>
        </table>
    </form:form>
    <a href="/adminpage"><p align="center">Admin page</p></a>
</div>
</body>
</html>
