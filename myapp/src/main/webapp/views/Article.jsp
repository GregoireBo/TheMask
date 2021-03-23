<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ page import="fr.cesi.TheMask.model.Example" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
    <head>
        ${Bootstrap}
        <title>${Title} - ${article.name} </title>
    </head>

    <body>
        <%@include file="Header.jsp" %>
        <div class="container">
            <c:forEach var="errorMessage" items="${ErrorMessageList}">
                <div>${errorMessage}</div>
            </c:forEach>
            
            Nom : ${article.name}<br>
            Description : ${article.descript}<br>
            Size : ${article.size}<br>
            <img src="data:image/png;base64,${image}" alt="Red dot" />
        </div>
    </body>
</html>