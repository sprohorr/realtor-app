<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Clients list</title>
</head>
<body style="background-color: lavender">
<h2 align="center">Users list</h2>
<div>
    <table border="2px" align="center">
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Email</th>
            <th>Login</th>
            <th>Create date</th>
            <th>Role</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.surname}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.login}"/></td>
                <td><c:out value="${user.createTime}"/></td>
                <td>
                    <c:choose>
                        <c:when test="${user.role.name eq 'ROLE_ADMIN'}">
                            <c:out value="ADMIN"/>
                        </c:when>
                        <c:when test="${user.role.name eq 'ROLE_USER'}">
                            <c:out value="USER"/>
                        </c:when>
                    </c:choose>
                </td>
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
