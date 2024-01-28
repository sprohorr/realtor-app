<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account agent</title>
</head>
<body style="background-color: lavender">
<div><h2 align="center">Account realty agent</h2></div>
<div>
    <table border="2px" align="center">
        <tr>
            <td><c:out value="Name: ${agent.name}"/></td>
        </tr>
        <tr>
            <td><c:out value="Number phone: ${agent.tel}"/></td>
        </tr>
        <tr>
            <td><c:out value="Email: ${agent.email}"/></td>
        </tr>
        <tr>
            <td><c:out value="Address: ${agent.address}"/></td>
        </tr>
        <tr>
            <td><a href="/agentedit?agent.id=${agent.id}">Edit</a></td>
        </tr>
        <tr>
            <td><a href="/apartmentadd?agent.id=${agent.id}">Add apartment for this agent</a></td>
        </tr>
        <tr>
            <td><a href="/apartmentlist?agent.id=${agent.id}">Apartments of list this agent</a></td>
        </tr>
    </table>
</div>
</body>
</html>
