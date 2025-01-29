<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User page</title>
</head>
<body style="background-color: lavender">
<div>
    <a href="/adminpage"><p>Admin page (only admin)</p></a>
    <a href="/logout">Log out</a>
    <h2>
        <c:choose>
            <c:when test="${user.role.name eq 'ROLE_ADMIN'}">
                <c:out value="ADMIN"/>
            </c:when>
            <c:when test="${user.role.name eq 'ROLE_USER'}">
                <c:out value="USER"/>
            </c:when>
        </c:choose>
        ${user.login}</h2></div>
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
        <tr>
            <td><a href="/useredit?userId=${user.id}">Edit</a></td>
        </tr>
    </table>
    <a href="/order?userId=${user.id}">Your order</a>
    <a href="/userreviewapartment?userId=${user.id}"><p>List apartments</p></a>
</div>
</body>
</html>
