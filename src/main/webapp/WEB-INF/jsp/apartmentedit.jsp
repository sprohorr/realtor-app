<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit apartment</title>
</head>
<body style="background-color: lavender">
<div><h2 align="center">Edit apartment</h2></div>
<div>
    <form:form action="${pageContext.request.contextPath}/apartmentedit" method="post" modelAttribute="apartment">
        <table align="center">
            <tr>
                <td><input type="hidden" name="apartment.id" value="${apartment.id}"></td>
            </tr>
            <tr>
                <td><form:input path="number"/>Number apartment</td>
            </tr>
            <tr>
                <td><form:input path="quantityRooms"/>Quantity rooms</td>
            </tr>
            <tr>
                <td><form:input path="area"/>Area</td>
            </tr>
            <tr>
                <td><form:input path="price"/>Price</td>
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
</div>
</body>
</html>
