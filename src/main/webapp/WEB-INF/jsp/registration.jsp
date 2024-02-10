<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
                <td><form:input path="name"/>Name</td>
            </tr>
            <tr>
                <td><form:input path="surname"/>Surname</td>
            </tr>
            <tr>
                <td><form:input path="email"/>Email</td>
            </tr>
            <tr>
                <td><form:input path="login"/>Login</td>
            </tr>
            <tr>
                <td><form:input path="password"/>Password</td>
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
