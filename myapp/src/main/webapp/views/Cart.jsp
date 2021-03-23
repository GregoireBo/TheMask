<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="fr.cesi.TheMask.model.Example"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<html>
    <head>
        ${Bootstrap}
        <title>${Title} - Sign in</title>
    </head>
    <body>
        <%@include file="Header.jsp" %>
        <div class="col-6 offset-3">
            <div class="list-group">
                <c:forEach var = "article" items = "${PersonConnected.cart.articles}"> <!-- A modifier -->
                    <div class="row border rounded mt-2 p-2">

                      <div class="col-5">
                          <a href="${DefaultPath}/Article?id=${article.id}"><img src="data:image/png;base64,${article.getPictureString()}" class="img-fluid"></a>
                      </div>
                      <div class="col-7">
                        <h3 class="title">${article.name}</h3>
                        <p class="text-muted"><span class="fas fa-euro-sign"></span> Gratuit</p>
                        <p>${article.descript}</p>
                      </div>
                    </div>
                    <hr>
                  </c:forEach>
                <c:if test="${PersonConnected.cart.articles.size() le 0}">
                    Pas d'articles dans le panier.
                </c:if>
              </div>
        </div>
    </body>
</html>