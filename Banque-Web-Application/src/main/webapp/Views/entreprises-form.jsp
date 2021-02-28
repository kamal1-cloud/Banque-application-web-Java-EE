<%--
  Created by IntelliJ IDEA.
  User: youcode
  Date: 27/02/2021
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="${pageContext.request.contextPath}/Css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <title>Home</title>
</head>
<body>
<div class = "container">
<div class = "row">
    <div class = "col-md-4">
        <form action = "${pageContext.request.contextPath}/AjouterEntreprise" method="POST">

            <div class = "form-group">
                <input type = "text" class = "form-control" name = "nom" placeholder = "Nom" value = "${pers.nom}"/>
            </div>

            <div class="form-group">
                <input type = "text" class = "form-control" name = "numero" placeholder = "Numero" value = "${pers.numero}"/>
            </div>

            <div class="form-group">
                <input type = "text" class = "form-control" name = "solde" placeholder = "Solde" value = "${pers.solde}"/>
            </div>

            <div class="form-group">
                <input type = "number" class = "form-control" name = "idClient" placeholder = "Type" value = "${pers.idClient}"/>
            </div>

            <input type = "hidden" name = "id" value = "${pers.idCompte}"/>

            <button type = "submit" class = "btn btn-primary">Save</button>
        </form>
    </div>
</div>
</div>
</body>
</html>
