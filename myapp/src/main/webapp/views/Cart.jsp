<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="fr.cesi.TheMask.model.Example"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<html>
    <head>
        ${Bootstrap}
        <title>${Title} - Panier</title>
    </head>
    <body>
        <%@include file="Header.jsp" %>
        <div>
        </div>
        <div class="container">
          <h1>Panier</h1>
          <div class="list-group">
              <c:forEach var = "article" items = "${PersonConnected.cart.articles}"> <!-- A modifier -->
                  <div class="row border rounded mt-2 p-2">

                    <div class="col-5">
                        <a href="${DefaultPath}/Article?id=${article.id}"><img src="${article.getPictureString()}" class="img-fluid"></a>
                    </div>
                    <div class="col-7">
                      <h3 class="title">${article.name}</h3>
                      <p class="text-muted"><span class="fas fa-euro-sign"></span> Gratuit</p>
                      <p>${article.descript}</p>
                      <p class="text-right">
                        <a class="btn btn-danger" href="${DefaultPath}/AddArticleToCart?articleId=${article.id}&type=delete"><i class="fas fa-trash-alt"></i></a>
                      </p>
                    </div>
                  </div>
                </c:forEach>
            </div>
            <c:choose>
              <c:when test="${PersonConnected.cart.articles.size() le 0}">
                Pas d'articles dans le panier.
              </c:when>
              <c:otherwise>
                <p class="text-right">
                  <button class="btn btn-primary text-white mt-5" onclick="command()">Commander</i></button>
                </p>
              </c:otherwise>
          </c:choose>
        </div>
    </body>
</html>

<script>
  function command() {
    alert('La commande à été passée, vous receverez vos articles sous peu !');
    window.location.replace("${DefaultPath}/AddArticleToCart?articleId=-1&type=clear");
  }
</script>