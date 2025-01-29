<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body style="background-color: lavender">
<div><h2 align="center">Registration</h2></div>
<div>
    <form:form action="/registration" method="post" modelAttribute="user">
        <table border="2px" align="center">
            <tr>
                <td>
                    <form:input path="name"/>Name
                    <br/>
                    <form:errors cssStyle="color: red" path="name"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:input path="surname"/>Surname
                    <br/>
                    <form:errors cssStyle="color: red" path="surname"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:input path="email"/>Email
                    <br/>
                    <form:errors cssStyle="color: red" path="email"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:input path="login"/>Login
                    <br/>
                    <form:errors cssStyle="color: red" path="login"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:input path="password"/>Password
                    <br/>
                    <form:errors cssStyle="color: red" path="password"/>
                </td>
            </tr>
            <tr>
                <td>
                    <button type="submit">Registration</button>
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
