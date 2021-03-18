<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="fr.cesi.TheMask.model.Example"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<html>
    <head>
        <title>${Title} - Signup</title>
    </head>
    <body>
        <div>
            <h1>${Title} - Signup</h1>
            <c:forEach var = "errorMessage" items = "${ErrorMessageList}">
                <div>${errorMessage}</div>
             </c:forEach>
            
            <form action="" method="POST">
                <label for="fname">Prénom :</label><br>
                <input type="text" id="firstName" name="firstName" value="${firstName}"><br>

                <label for="lname">Nom :</label><br>
                <input type="text" id="lastName" name="lastName" value="${lastName}"><br>

                <label for="email">Mail :</label><br>
                <input type="email" id="email" name="email" value="${email}"><br>

                <label for="password">Password :</label><br>
                <input type="password" id="password" name="password" value="${password}"><br>

                <button type="submit">Valider</button>
              </form>
        </div>
    </body>
    </html>