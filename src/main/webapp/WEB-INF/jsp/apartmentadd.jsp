<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new apartment</title>
</head>
<body style="background-color: lavender">
<div><h2 align="center">Add new apartment. Address ${building.address}</h2></div>
<div>
    <form:form action="/apartmentadd" method="post" modelAttribute="apartment">
        <input type="hidden" name="buildingId" value="${building.id}"/>
        <table align="center" border="2px">
            <tr>
                <td>
                    <form:label path="realtyAgent.id">Agent:</form:label>
                    <form:select path="realtyAgent.id">
                        <form:option value="2">Select agent</form:option>
                        <c:forEach items="${listagent}" var="agent">
                            <form:option value="${agent.id}">${agent.name}</form:option>
                        </c:forEach>
                    </form:select>
                    <br/>
                    <form:errors cssStyle="color: red" path="realtyAgent.id"/>
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
