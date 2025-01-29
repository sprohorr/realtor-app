<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
    <style>
        nav {
            display: flex;
        }

        .a {
            display: flex;
            margin-left: auto;
        }

        .b {
            margin: 6px;
        }
    </style>
</head>
<body style="background-color: lavender">
<header>
    <nav>
        <div class="a">
            <%--            <span style="float: right">--%>
            <%--                <a href="?lang=en">en</a>--%>
            <%--                <a href="?lang=ru">ru</a>--%>
            <%--            </span>--%>
            <a class="b" href="/registration">Registration</a>
            <a class="b" href="/login">log in</a>
        </div>
    </nav>
</header>
<h1 align="center">Realtor app</h1>
<div>
    <div align="center">
        <img height="50%" width="50%"
             src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQYP-4Kptnw4G1kcSb0ZVclfWjwI4KHi_bkUA&usqp=CAU">
    </div>
</div>
</body>
</html>
