<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
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
                <td><a href="/agentpage?agentId=${agent.id}"><c:out value="${agent.name}"/></a></td>
            </tr>
            <br/>
        </c:forEach>
    </table>
    <a href="/adminpage"><p align="center">Return to back</p></a>
</div>
</body>
</html>
