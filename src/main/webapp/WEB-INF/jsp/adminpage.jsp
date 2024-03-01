<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page</title>
</head>
<body style="background-color: lavender">
<div align="center">
    <jsp:include page="userpage.jsp"></jsp:include>
</div>
<a href="/registrationadmin"><p align="center">Add new admin</p></a>
<div>
    <h2 align="center" style="color: slateblue">Realty agent</h2>
    <table border="2px" align="center">
        <tr>
            <td><a href="/agentlist">List of realty agents</a></td>
        </tr>
        <tr>
            <td><a href="/agentadd">Add realty agent</a></td>
        </tr>
    </table>
    <br/>
    <h2 align="center" style="color: slateblue">Building</h2>
    <table border="2px" align="center">
        <tr>
            <td><a href="/buildinglist">Buildings of list</a></td>
        </tr>
        <tr>
            <td><a href="/buildingadd">Add building</a></td>
        </tr>
    </table>
    <br/>
    <h2 align="center" style="color: slateblue">Users</h2>
    <table border="2px" align="center">
        <tr>
            <td><a href="/userlist">Users list</a></td>
        </tr>
    </table>
</div>
</body>
</html>
