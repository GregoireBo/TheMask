<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ page import="fr.cesi.TheMask.model.Example" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


            <html>

            <head>
                <title>${Title} - AddArticle</title>
            </head>

            <body>
                <div>
                    <h1>${Title} - AddArticle</h1>
                    <c:forEach var="errorMessage" items="${ErrorMessageList}">
                        <div>${errorMessage}</div>
                    </c:forEach>

                    <form action="" method="POST" enctype="multipart/form-data">
                        <label for="name">Nom :</label><br>
                        <input type="text" id="name" name="name" value="${name}"><br>

                        <label for="descr">Description :</label><br>
                        <input type="text" id="descr" name="descr" value="${descr}"><br>

                        <label for="size">Size :</label><br>
                        <select name="size" id="size-select">
                            <option value="">--Please choose a size--</option>
                            <option value="S">S</option>
                            <option value="M">M</option>
                            <option value="L">L</option>
                            <option value="XL">XL</option>
                        </select><br>
                        <label for="fichier">Photo</label>
                        <input type="file" id="fichier" name="fichier" /><br>

                        <button type="submit">Valider</button>
                    </form>
                </div>
            </body>

            </html>