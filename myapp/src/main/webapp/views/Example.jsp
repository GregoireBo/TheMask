<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="fr.cesi.TheMask.model.Example"%>


<html>
    <head>
        <title>Page d'exemple du projet JAVA masque</title>
    </head>
    <body>
        <%
            Example example = new Example();
            if (request.getAttribute("ExampleAttribute") != null) {
                example = (Example) request.getAttribute("ExampleAttribute");
            }
        %>
        <h1>Page d'exemple du projet JAVA masque</h1>
        On récupère ici un objet Example complété aléatoirement.
        <br>
        Example.text1 : <%= example.getText1()%>
        <br>
        Example.text2 : <%= example.getText2()%>
    </body>
</html>