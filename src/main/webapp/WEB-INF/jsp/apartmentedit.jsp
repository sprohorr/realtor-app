<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit apartment</title>
</head>
<body style="background-color: lavender">
<div><h2 align="center">Edit apartment</h2></div>
<div>
    <form:form action="/apartmentedit" method="post" modelAttribute="apartment">
        <table align="center" border="2px">
            <tr>
                <td><form:input path="realtyAgent.id"/>ID realty agent
                    <br/>
                    <form:errors cssStyle="color: red" path="realtyAgent.id"/>
                </td>
            </tr>
            <tr>
                <td><form:input path="building.id"/>ID building
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
                    <button type="submit">Edit</button>
                </td>
            </tr>
        </table>
    </form:form>
    <a href="/adminpage"><p align="center">Admin page</p></a>
</div>
</body>
</html>
