<%@ page import="models.Article" %>
<%@ page import="java.util.LinkedList" %><%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 10.12.2016
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/newPrisonerForm.css">
</head>
<body>
<div idPrisoner="newPrisoner">
    <h1>Add prisoner</h1>
    <fieldset>
        <form method="post" name="newPrisoner">
            <input type="text" name="firstname" placeholder="First name" style="border-radius: 3px 3px 0px 0px" required>
            <input type="text" name="lastname" placeholder="Last name" style="border-radius: 0px 0px 3px 3px" required>
            <label style="padding-top: 5px;" for="dateOfBirth">Date of birth</label>
            <input type="date" name="dateOfBirth" id="dateOfBirth" placeholder="Date of birth" required>
            <label for="detention">Detention</label>
            <input type="date" name="detention" placeholder="Detention" id="detention" required>
            <label for="released">Release</label>
            <input type="date" name="released" placeholder="Release" id="released" style="border-radius: 0px 0px 3px 3px" required>
            <select name="articles" size = 3 multiple idPrisoner="articles" style="width: 260px; border-radius: 0px 0px 3px 3px;" required>
                <% LinkedList<Article> articles = (LinkedList<Article>) request.getAttribute("articles");%>
                <% for (int i = 0; i < articles.size(); i++) { %>
                <option value="<%=articles.get(i).getNumber()%>">Article <%= articles.get(i).getNumber()%></option>
                <%}%>
            </select>
            <input type="submit" value="Add" onclick="document.newPrisoner.action = 'newPrisoner'">
        </form>
    </fieldset>
</div>
</body>
</html>
