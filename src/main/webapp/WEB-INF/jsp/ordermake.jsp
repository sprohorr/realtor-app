<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Make an order</title>
</head>
<body style="background-color: lavender">
<div><h2 align="center" style="color: slateblue">Make an order</h2></div>
<div><form:form action="/ordermake" method="post" modelAttribute="order">
    <input type="hidden" name="apartmentId" value="${apartment.id}"/>
    <input type="hidden" name="userId" value="${user.id}"/>
    <button style="color: slateblue" type="submit">Create order</button>
</form:form>
</div>
<a href="/userreviewapartment?userId=${user.id}">Return to back</a>
</body>
</html>
