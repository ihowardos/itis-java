<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Edit Form</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
</head>

<body>
<div class="container">
    <div class="generic-container">
        <%@include file="../app/authheader.jsp" %>

        <div class="well lead">User Edit Form</div>
        <form:form method="POST" modelAttribute="user" class="form-horizontal" action="/${username}/edit">
            <form:input type="hidden" path="id" id="id" class="form-control input-sm"/>
            <form:input type="hidden" path="created_at" id="created_at" class="form-control input-sm"/>
            <form:input type="hidden" path="updated_at" id="updated_at" class="form-control input-sm"/>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="login">Login</label>
                    <div class="col-md-7">
                        <form:input type="text" path="login" id="login" class="form-control input-sm" onfocus="true" disabled="true"/>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="email">Email</label>
                    <div class="col-md-7">
                        <form:input type="email" path="email" id="email" class="form-control input-sm" disabled="false"/>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="password">Password</label>
                    <div class="col-md-7">
                        <form:input type="password" path="password" id="password" class="form-control input-sm"/>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-actions floatRight">
                            <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a
                                href="<c:url value='/list' />">Cancel</a>
                </div>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>