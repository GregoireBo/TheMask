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
        <div class="col-6 offset-3 mt-2">
            <div class="list-group">
                <c:forEach var = "article" items = "${PersonConnected.cart.articles}">
                    <div class="list-group-item list-group-item-action">
                        <div class="d-flex w-100 justify-content-between">
                          <h5 class="mb-1">${article.name}</h5>
                          <i class="fas fa-trash-alt"></i>
                        </div>
                        <p class="mb-1">${article.descript}</p>
                    </div>
                </c:forEach>
              </div>
        </div>
    </body>
</html>