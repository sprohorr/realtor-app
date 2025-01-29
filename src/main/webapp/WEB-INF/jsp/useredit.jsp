<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body style="background-color: lavender">
<div><h2 align="center">Edit ${user.login}</h2></div>
<div>
    <form:form action="/useredit" method="post" modelAttribute="user">
        <input type="hidden" name="userId" value="${user.id}"/>
        <input type="hidden" name="login" value="${user.login}"/>
        <input type="hidden" name="password" value="${user.password}"/>
        <table align="center" border="2px">
            <tr>
                <td><form:input path="name"/>Name
                    <br/>
                    <form:errors cssStyle="color: red" path="name"/>
                </td>
            </tr>
            <tr>
                <td><form:input path="surname"/>Surname
                    <br/>
                    <form:errors cssStyle="color: red" path="surname"/>
                </td>
            </tr>
            <tr>
                <td><form:input path="email"/>Email
                    <br/>
                    <form:errors cssStyle="color: red" path="email"/>
                </td>
            </tr>
            <tr>
                <td>
                    <button type="submit">Edit</button>
                </td>
            </tr>
        </table>
    </form:form>
    <a href="/userpage"><p align="center">User page</p></a>
</div>
</body>
</html>
