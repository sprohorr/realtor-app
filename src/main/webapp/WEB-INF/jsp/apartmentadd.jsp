<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new apartment</title>
</head>
<body style="background-color: lavender">
<div><h2 align="center">Add new apartment. Realty Agent ${agent.name}</h2></div>
<div>
    <form:form action="/apartmentadd" method="post" modelAttribute="apartment">
        <input type="hidden" name="agentId" value="${apartment.realtyAgent.id}"/>
        <table align="center" border="2px">
            <tr>
                <td><form:input path="building.id"/>Id building
                    <br/>
                    <form:errors cssStyle="color: red" path="building.id"/>
                </td>
            </tr>
            <tr>
                <td><form:input path="number"/>Number apartment
                    <br/>
                    <form:errors cssStyle="color: red" path="number"/>
                </td>
            </tr>
            <tr>
                <td><form:input path="quantityRooms"/>Quantity rooms
                    <br/>
                    <form:errors cssStyle="color: red" path="quantityRooms"/>
                </td>
            </tr>
            <tr>
                <td><form:input path="area"/>Area
                    <br/>
                    <form:errors cssStyle="color: red" path="area"/>
                </td>
            </tr>
            <tr>
                <td><form:input path="price"/>Price
                    <br/>
                    <form:errors cssStyle="color: red" path="price"/>
                </td>
            </tr>
            <tr>
                <td><form:input path="description"/>Description</td>
            </tr>
            <tr>
                <td>Status
                    Active<form:radiobutton path="status" value="1"/>
                    Close<form:radiobutton path="status" value="0"/>
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
