<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body style="background-color: lavender">
<header><h2 align="center">Log in</h2></header>
<div>
    <form:form action="/login" method="post" modelAttribute="login">
        <table align="center" style="border: slateblue">
            <tr>
                <td><form:input path="login"/></td>
            </tr>
            <tr>
                <td><form:input path="password"/></td>
            </tr>
            <tr>
                <td>
                    <button type="submit">Log in</button>
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
