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
<div class="container">
    <form class="form-inline d-flex md-form form-sm mb-4">
        <i class="fas fa-search" aria-hidden="true"></i>
        <input class="form-control form-control-sm ml-3 w-75" type="text" name="word" placeholder="Search"
               aria-label="Search">
    </form>
    <form class="form-inline d-flex md-form form-sm mb-4">
    <a href="<%=request.getContextPath()%>/Views/entreprises-form.jsp" class="btn btn-success">Add
        New User</a>
    </form>
    <!-- Search form -->

    <div class="container">
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th>Nom</th>
            <th>Numero</th>
            <th>Solde</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="entreprise">
            <tr>
                <td>${entreprise.nom}</td>
                <td>${entreprise.numero}</td>
                <td>${entreprise.solde}</td>
                <td>
                    <a href = "${pageContext.request.contextPath}/enterprise-servletr?action=EDIT&id=${entreprise.idCompte}">Edit</a>
                    |
                    <a href = "${pageContext.request.contextPath}/enterprise-servlet?action=DELETE&id=${entreprise.idCompte}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
    </div>
</div>
    </div>
</div>
</body>
</html>