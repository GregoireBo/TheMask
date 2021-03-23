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

            <div class="card mt-5">
                <img src="${article.getPictureString()}" alt="Red dot" />
                <div class="card-body">
                    <h3>${article.name}</h3>
                    <p class="card-text">${article.descript}</p>
                    <p class="card-text">Taille : ${article.size}</p>
                    <p class="card-text"><span class="fas fa-euro-sign"></span> Gratuit</p>
                    <p class="text-right">
                        <c:if test="${not empty PersonConnected}">
                            <a class="btn btn-success" href="${DefaultPath}/AddArticleToCart?articleId=${article.id}">Ajouter au panier</a>
                        </c:if>
                    </p>
                </div>
            </div>
        </div>
    </body>
</html>