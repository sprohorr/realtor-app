<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload from excel</title>
</head>
<body style="background-color: lavender">
<div style="color: darkgray"><h2>Import file</h2></div>
<div>
    <form:form action="/import" method="post" enctype="multipart/form-data">
        <input type="file" name="file"/>
        <br/>
        <input type="submit" value="Import">
    </form:form>
</div>

</body>
</html>
