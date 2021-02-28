<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="${pageContext.request.contextPath}/Css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <title>Home</title>
</head>
<body>
<div class="row">
    <div class="col-md-8 mx-auto mt-xl-5">

    <div class="col-md-12">
    <form class="form-inline d-flex md-form form-sm mb-4">
        <i class="fas fa-search" aria-hidden="true"></i>
        <input class="form-control form-control-sm ml-3 w-75" type="text" placeholder="Search"
               aria-label="Search">
    </form>
    </div>
    <div class="col-md-1">
    <form class="form-inline d-flex md-form form-sm mb-4">
        <a href="<%=request.getContextPath()%>/Views/personnes-form.jsp" class="btn btn-success">Add
            New User</a>
    </form>
    </div>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th>Nom</th>
            <th>Prenom</th>
            <th>Numero</th>
            <th>Solde</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list2}" var="personne">
            <tr>
                <td>${personne.nom}</td>
                <td>${personne.prenom}</td>
                <td>${personne.numero}</td>
                <td>${personne.solde}</td>
                <td>
                    <a href = "${pageContext.request.contextPath}/persons-servlet?action=EDIT&id=${personne.idCompte}">Edit</a>
                    |
                    <a href = "${pageContext.request.contextPath}/persons-servlet?action=DELETE&id=${personne.idCompte}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</div>

</div>
</body>
</html>