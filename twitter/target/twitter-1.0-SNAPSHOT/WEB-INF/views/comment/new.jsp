<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New Comment</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
    <div class="well lead">New Comment</div>
    <form:form method="POST" modelAttribute="comment" class="form-horizontal" action="/${user.login}/${twit.id}/comment">
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="text">Comment</label>
                <div class="col-md-7">
                    <form:input type="text" path="text" id="text" class="form-control input-sm"
                                required="true" maxlength="120"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-actions floatRight">
                <input type="submit" value="Create twit" class="btn btn-primary btn-sm"/>
            </div>
        </div>
    </form:form>
</body>
</html>