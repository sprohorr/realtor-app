<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account agent</title>
</head>
<body>
<div>
    <p>Name: ${agent.name}</p>
    <p>Number phone: ${agent.tel}</p>
    <p>Email: ${agent.email}</p>
    <p>Address: ${agent.address}</p>
    <a href="/agentedit?agent.id=${agent.id}">Edit</a><br/>
    <a href="/apartmentadd?agent.id=${agent.id}">Add apartment</a><br/>
    <a href="/apartmentlist">Apartments of list</a>
</div>
</body>
</html>
