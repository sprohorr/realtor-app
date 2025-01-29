<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
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
            <td><a href="/agentedit?agentId=${agent.id}">Edit</a></td>
        </tr>
        <tr>
            <td><a href="/apartmentlist?agentId=${agent.id}">Apartments of list this agent</a></td>
        </tr>
    </table>
    <a href="/adminpage"><p align="center">Admin page</p></a>
</div>
</body>
</html>
