<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ page import="fr.cesi.TheMask.model.Example" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>

    <head>
        ${Bootstrap}
        <title>${Title} - Ajout d'article</title>
    </head>

    <body>
        <%@include file="Header.jsp" %>
        <div class="container">
            <div>
                <h1>${Title} - Ajout d'article</h1>
            </div>
            <div class="row col-12">
                <c:forEach var="errorMessage" items="${ErrorMessageList}">
                    <div>${errorMessage}</div>
                </c:forEach>

                <form class="col-12" action="" method="POST" enctype="multipart/form-data">
                    <div class="form-group col-12">
                        <label for="name">Nom :</label><br>
                        <input class="form-control" type="text" id="name" name="name" value="${name}"><br>

                        <label for="descr">Description :</label><br>
                        <textarea class="form-control" id="descr" name="descr">${descr}</textarea><br>

                        <label for="size">Size :</label><br>
                        <select class="form-control" name="size" id="size-select">
                            <option value="">--Please choose a size--</option>
                            <option value="S">S</option>
                            <option value="M">M</option>
                            <option value="L">L</option>
                            <option value="XL">XL</option>
                        </select><br>
                        <label for="fichier">Photo</label>
                        <input class="form-control" type="file" id="fichier" name="fichier" /><br>

                        <button class="form-control btn btn-success" type="submit">Valider</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>