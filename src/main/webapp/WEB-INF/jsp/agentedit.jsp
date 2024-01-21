<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Edit realty agent</title>
</head>
<body style="background-color: lavender">
<div><h2 align="center">Edit realty agent</h2></div>
<div align="center">
  <form:form action="${pageContext.request.contextPath}/agentedit" method="post" modelAttribute="agent">
    <table>
      <tr>
        <td><input type="hidden" name="agent.id" value="${agent.id}"/></td>
      </tr>
      <tr>
        <td><form:input path="name"/>Name</td>
      </tr>
      <tr>
        <td><form:input path="tel"/>Number phone</td>
      </tr>
      <tr>
        <td><form:input path="email"/>Email</td>
      </tr>
      <tr>
        <td><form:input path="address"/>Address</td>
      </tr>
    </table>
    <button type="submit">Edit</button>
  </form:form>
</div>

</body>
</html>
