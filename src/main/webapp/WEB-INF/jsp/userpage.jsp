<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client page</title>
</head>
<body style="background-color: lavender">
<div><h2 align="center">User page</h2></div>

<div>
    <table border="2px">
        <tr>
            <td><c:out value="Name: ${user.name}"/></td>
        </tr>
        <tr>
            <td><c:out value="Surname: ${user.surname}"/></td>
        </tr>
        <tr>
            <td><c:out value="Email: ${user.email}"/></td>
        </tr>
    </table>
</div>
<div><a href="/logout">Log out</a>
</div>

</body>
</html>
