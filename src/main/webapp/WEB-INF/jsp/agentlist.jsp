<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List agents</title>
</head>
<body style="background-color: lavender">
<div><h2 align="centre">List realty agents</h2></div>
<div>
    <table border="2px">
        <c:forEach items="${agent}" var="agent">
            <tr>
                <td><p>Name: ${agent.name}</p></td>
                <td><a href="/agentaccountpage?agent.id=${agent.id}">Account page</a></td>
                <td><a href="/apartmentlist?agent.id=${agent.id}">List of apartment</a></td>
            </tr>
            <br/>
        </c:forEach>
    </table>
</div>
</body>
</html>
