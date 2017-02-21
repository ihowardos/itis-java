<%@ page import="java.util.LinkedList" %>
<%@ page import="models.Article" %>
<%@ page import="models.Prisoner" %>
<%@ page import="services.*" %>
<%@ page import="models.Prison" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/home.css" type="text/css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/bootstrap-theme.css">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>

    <title>Home</title>
</head>

<body>

    <div class="container" style="margin-top: 10px;">
        <a href="/exit" style="float: right;">Exit</a>

        <% Prison prison = (Prison) request.getAttribute("prison");

           LinkedList<Prisoner> prisoners = (LinkedList<Prisoner>) request.getAttribute("prisonersWithArticles");
           String prisonIsNotCreate = (String) request.getAttribute("prisonIsNotCreate");

        if (prisonIsNotCreate == null) {
            int amt = (Integer) request.getAttribute("amt");
            if (amt < prison.getCapacity()) { %>
                <a href="/newPrisoner">Add new prisoner</a>

                <h1>Name of prison: <%= prison.getName()%></h1>
                <p>City: <%= prison.getCity()%></p>
                <p style="color: green;">Capacity: <%= amt%>/<%=prison.getCapacity()%></p>
                <% } else { %>
                <p style="color: red;">Prison is full!</p>
                <h1>Name of prison: <%= prison.getName()%></h1>
                <p>City: <%= prison.getCity()%></p>
                <p style="color: red;">Capacity: <%= amt%>/<%= prison.getCapacity()%></p>
        <%}%>

        <table class="table table-striped">
            <tr>
                <th>ID</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Date of birth</th>
                <th>Detention</th>
                <th>Release</th>
                <th>Articles</th>
            </tr>

                <% for (int i = 0; i < prisoners.size(); i++) { %>
            <tr>
                    <td><%= prisoners.get(i).getIdPrisoner()%></td>
                    <td><%= prisoners.get(i).getFirstname()%></td>
                    <td><%= prisoners.get(i).getLastname()%></td>
                    <td><%= prisoners.get(i).getDateOfBirth()%></td>
                    <td><%= prisoners.get(i).getDetention()%></td>
                    <td><%= prisoners.get(i).getReleased()%></td>
                    <td>
                        <% LinkedList<Integer> articles = (LinkedList<Integer>) prisoners.get(i).getArticles();
                            for (int j = 0; j < articles.size(); j++) { %>
                               <%= articles.get(i)%>,
                           <% }%>
                    </td>
                    <td> X </td>
            </tr>
               <% } %>
        </table>
        <% }
        else { %>
            <a href="/newPrison">Add prison</a>
            <h1><%= prisonIsNotCreate%></h1>
        <% } %>
    </div>
</body>
</html>