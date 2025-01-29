<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new agent</title>
</head>
<body style="background-color: lavender">
<div><h2 align="center">Add new agent</h2></div>
<div>
    <form:form action="/agentadd" method="post" modelAttribute="agent">
        <table align="center" border="2px">
            <tr>
                <td><form:input path="name"/>Name
                    <br/>
                    <form:errors cssStyle="color: red" path="name"/>
                </td>
            </tr>
            <tr>
                <td><form:input path="tel"/>Number phone
                    <br/>
                    <form:errors cssStyle="color: red" path="tel"/>
                </td>
            </tr>
            <tr>
                <td><form:input path="email"/>Email
                    <br/>
                    <form:errors cssStyle="color: red" path="email"/>
                </td>
            </tr>
            <tr>
                <td><form:input path="address"/>Address
                    <br/>
                    <form:errors cssStyle="color: red" path="address"/>
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
