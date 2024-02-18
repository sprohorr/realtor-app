<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Clients list</title>
</head>
<body style="background-color: lavender">
<h2 align="center">Users list</h2>
<div>
    <table border="2px" align="center">
        <c:forEach var="user" items="${users}">
            <tr>
                <td><c:out value="Name: ${user.name}"/></td>
                <td><c:out value="Surname: ${user.surname}"/></td>
                <td><c:out value="Email: ${user.email}"/></td>
                <td><c:out value="Login: ${user.login}"/></td>
                <td><c:out value="Create date: ${user.createTime}"/></td>
                <td><c:out value="Role: ${user.role.name}"/></td>
                <td><a href="#">feedback</a></td>
                <td><a href="#">order</a></td>
            </tr>
            <br/>
        </c:forEach>
    </table>
    <a href="/adminpage">Return to back</a>
</div>
</body>
</html>
