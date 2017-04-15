<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>${username} | profile</title>
    <link href="<c:url value='/static/css/bootstrap.css'/>" rel="stylesheet"/>
    <link href="<c:url value='/static/css/app.css'/>" rel="stylesheet"/>
</head>

<body>
<%@include file="../app/authheader.jsp" %>
<div class="panel panel-default">
    <div class=panel-heading"><span class="lead">Profile</span></div>
    <hr>
    <h1>${user.login}</h1>
    <c:forEach items="${user.twits}" var="twit">
    <a href="<c:url value="/${user.login}/${twit.id}"/>">${twit.text}</a>
    <br>
        ${twit.created_at}
        <a href="<c:url value="/${user.login}/${twit.id}/delete"/>">Удалить</a>

        <hr>
    <br>
</c:forEach>
        </div>
<%@include file="../twit/new.jsp"%>
</body>
</html>