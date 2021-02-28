
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="${pageContext.request.contextPath}/Css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <title>Home</title>
</head>
<body>
<div class = "container">
    <div class="float-right">
        <a href="${pageContext.request.contextPath}/logout.jsp">Logout</a>
    </div>
    <h1>Employee Directory</h1>
    <hr/>

    <div class = "row">
        <div class = "col-md-4">
            <form action = "${pageContext.request.contextPath}/AjoutePersonne" method="POST">

                <div class = "form-group">
                    <input type = "text" class = "form-control" name = "nom" placeholder = "Nom" value = "${pers.nom}"/>
                </div>

                <div class = "form-group">
                    <input type = "text" class = "form-control" name = "Prenom" placeholder = "Prenom"  value = "${pers.prenom}"/>
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
    <a href = "${pageContext.request.contextPath}/persons-servlet">Back to List</a>
</div>

</body>
</html>
