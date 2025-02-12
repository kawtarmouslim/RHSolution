<%@ page import="entites.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">


        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Users</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center">List of Users</h3>
        <hr>
        <div class="container text-left">

            <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
                New User</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Poste</th>
                <th>Salaire</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <%

                List<User> userList = (List<User>) request.getAttribute("listUser");


                for (User user : userList) {
            %>
            <tr>
                <td><%= user.getId() %></td>
                <td><%= user.getNom() %></td>
                <td><%= user.getPrenom() %></td>
                <td><%= user.getPoste() %></td>
                <td><%= user.getSalaire()%></td>
                <td>
                    <a href="updatePerson?id=<%= user.getId() %>" class="btn btn-warning btn-sm">Edit</a>
                    <form action="deleteUser" method="post" style="display:inline;">
                        <input type="hidden" name="id" value="<%= user.getId() %>" />
                        <input type="submit" value="Delete" class="btn btn-danger btn-sm" />
                    </form>
                </td>
            </tr>
            <%
                }
            %>
            </tbody>


        </table>
    </div>
</div>
</body>
</html>