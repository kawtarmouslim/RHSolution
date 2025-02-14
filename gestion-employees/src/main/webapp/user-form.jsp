<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
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
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <%
                String id = request.getParameter("id") != null ? request.getParameter("id") : "";
                String nom = request.getParameter("nom") != null ? request.getParameter("nom") : "";
                String prenom = request.getParameter("prenom") != null ? request.getParameter("prenom") : "";
                String poste = request.getParameter("poste") != null ? request.getParameter("poste") : "";
                String salaire = request.getParameter("salaire") != null ? request.getParameter("salaire") : "";
                boolean isEditing = !id.isEmpty();
            %>
            <form action="<%= request.getContextPath() %>/<%= isEditing ? "update" : "insert" %>" method="post">
                <input type="hidden" name="id" value="<%= id %>">

                <fieldset class="form-group">
                    <label>Nom</label>
                    <input type="text" class="form-control" name="nom" value="<%= nom %>" required>
                </fieldset>
                <fieldset class="form-group">
                    <label>Prénom</label>
                    <input type="text" class="form-control" name="prenom" value="<%= prenom %>" required>
                </fieldset>
                <fieldset class="form-group">
                    <label>Poste</label>
                    <input type="text" class="form-control" name="poste" value="<%= poste %>" required>
                </fieldset>
                <fieldset class="form-group">
                    <label>Salaire</label>
                    <input type="number" class="form-control" name="salaire" value="<%= salaire %>" required>
                </fieldset>
                <button type="submit" class="btn <%= isEditing ? "btn-warning" : "btn-success" %>">
                    <%= isEditing ? "Update" : "Save" %>
                </button>

            </form>
        </div>
    </div>
</div>
</body>
</html>
