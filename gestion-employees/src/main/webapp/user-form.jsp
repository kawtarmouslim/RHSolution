<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
                <form action="<%=request.getContextPath()%>/insert" method="post">
                    <fieldset class="form-group">
                        <label>Nom</label>
                        <input type="text" class="form-control" name="nom" required>
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Prénom</label>
                        <input type="text" class="form-control" name="prenom" required>
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Poste</label>
                        <input type="text" class="form-control" name="poste" required>
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Salaire</label>
                        <input type="number" class="form-control" name="salaire" required>
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>

        </div>
    </div>
</div>
</body>
</html>
