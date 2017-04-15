<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 09.04.2017
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h1>Welcome, dear ${username}!</h1>
    <c:choose>
        <c:when test="${username == 'Guest'}">
            <span class="floatRight"><a href="<c:url value="/registration"/>"> Sign up</a></span>
            <span class="floatRight"><a href="<c:url value="/login" />"> Log in</a></span>
        </c:when>
        <c:otherwise>
            <span class="floatRight"><a href="<c:url value="/${username}"/>"> Мой профиль</a></span>
            <span class="floatRight"><a href="<c:url value="/list" />"> Список юзеров</a></span>
        </c:otherwise>
    </c:choose>

</body>
</html>
