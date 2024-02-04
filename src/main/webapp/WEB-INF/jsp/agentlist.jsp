<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List agents</title>
</head>
<body style="background-color: lavender">
<div><h2 align="center">List realty agents</h2></div>
<div>
    <table border="2px" align="center">
        <c:forEach items="${agent}" var="agent">
            <tr>
                <td><c:out value="Name: ${agent.name}"/></td>
                <td><a href="/agentaccountpage?agentId=${agent.id}">Account page</a></td>
                <td><a href="/apartmentlist?agentId=${agent.id}">List of apartment</a></td>
            </tr>
            <br/>
        </c:forEach>
    </table>
</div>
</body>
</html>
