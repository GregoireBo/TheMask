<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="fr.cesi.TheMask.model.Example"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<html>
    <head>
        <title>Page d'exemple du projet JAVA masque</title>
    </head>
    <body>
        <c:forEach var = "example" items = "${ExampleListAttribute}">

            Text 1 <c:out value = "${example.text1}"/><p>
            Text 2 ${example.text2}<p>
            
            Text 2 getter ${example.getText2()}
            <hr>
         </c:forEach>
    </body>
</html>