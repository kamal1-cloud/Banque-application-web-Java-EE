<%--
  Created by IntelliJ IDEA.
  User: youcode
  Date: 28/02/2021
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class = "row">
    <div class = "col-md-4">
        <form action = "${pageContext.request.contextPath}/AjoutePersonne" method="POST">

            <div class = "form-group">
                <input type = "text" class = "form-control" name = "nom" placeholder = "Enter Le nom" value = "${pers.nom}"/>
            </div>

            <div class = "form-group">
                <input type = "text" class = "form-control" name = "Prenom" placeholder = "prenom"  value = "${pers.prenom}"/>
            </div>

            <div class="form-group">
                <input type = "text" class = "form-control" name = "numero" placeholder = "Numero" value = "${pers.numero}"/>
            </div>

            <div class="form-group">
                <input type = "text" class = "form-control" name = "solde" placeholder = "Soldes" value = "${pers.solde}"/>
            </div>

            <div class="form-group">
                <input type = "number" class = "form-control" name = "idClient" placeholder = "Type" value = "${pers.idClient}"/>
            </div>

            <input type = "hidden" name = "id" value = "${pers.idCompte}"/>

            <button type = "submit" class = "btn btn-primary">Save</button>
        </form>
    </div>
</div>
</body>
</html>
