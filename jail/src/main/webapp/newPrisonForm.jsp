<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 01.12.2016
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Prison</title>
    <link rel="stylesheet" href="css/newPrisonForm.css">
</head>
<body>
    <div idPrisoner="newPrison">
        <h1>New prison</h1>
        <fieldset>
            <form method="post" name="newPrison">
                <input type="text" name="name" placeholder="Name of prison" style="border-radius: 3px 3px 0px 0px">
                <input type="text" name="city" placeholder="City of prison">
                <input type="number" name="capacity" placeholder="Enter capacity" style="border-radius: 0px 0px 3px 3px">
                <input type="submit" value="Add" onclick="document.newPrison.action = 'newPrison'">
            </form>

            <% String error = (String) request.getAttribute("thisNameInUse");
            if (error != null) { %>
            <p style="color: red;"><%=error%></p>
            <%}%>
        </fieldset>
    </div>
</body>
</html>
