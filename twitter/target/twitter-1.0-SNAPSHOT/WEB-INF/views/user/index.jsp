<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Users List</title>
    <link href="<c:url value='/static/css/bootstrap.css'/>" rel="stylesheet"/>
    <link href="<c:url value='/static/css/app.css'/>" rel="stylesheet"/>
</head>

<body>
<div class="container">
    <div class="generic-container">
        <%@include file="../app/authheader.jsp" %>
        <div class="panel panel-default">
            <div class="panel-heading"><span class="lead">List of Users</span></div>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Login</th>
                    <th>Email</th>
                    <th>Created at</th>
                    <th>Updated at</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td><a href="<c:url value="/${user.login}"/>">${user.login}</a></td>
                        <td>${user.email}</td>
                        <td>${user.created_at}</td>
                        <td>${user.updated_at}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>