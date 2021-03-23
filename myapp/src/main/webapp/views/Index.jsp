<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="fr.cesi.TheMask.model.Cart"%>
<%@ page import="fr.cesi.TheMask.model.Article"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<html>
    <head>

        <style>
            .pagination > li > a:focus,
            .pagination > li > a:hover,
            .pagination > li > span:focus,
            .pagination > li > span:hover,
            .pagination > .active > .page-link {
                z-index: 3;
                color: #23527c;
                background-color: green !important;
                border-color: #ddd !important;
            }

        .carousel-inner > .carousel-item > img {
            height: 360px;
            margin: auto;
          }
        </style>

        ${Bootstrap}
        <title>${Title} - Index</title>
    </head>
    <body>
        <%@include file="Header.jsp" %>

            <div class="container">
                <div id="carousel" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                    <img class="d-block w-100" src="img/carrousel1.png" alt="First slide">
                    </div>
                    <div class="carousel-item">
                    <img class="d-block w-100" src="img/carrousel2.png" alt="Second slide">
                    </div>
                    <div class="carousel-item">
                    <img class="d-block w-100" src="img/carrousel3.png" alt="Third slide">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carousel" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carousel" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
                </div>
            </div>
            <div class="container">
              <div class="col-12">
                  <div class="row mt-4">

                    
                  <hr class="col-12">
                  <c:forEach var = "article" items = "${listArticles}"> <!-- A modifier -->
                    <div class="row col-12">
                      <div class="col-5">
                          <a href="${DefaultPath}/Article?id=${article.id}"><img src="${article.getPictureString()}" class="img-fluid"></a>
                      </div>
                      <div class="col-7">
                        <h3 class="title">${article.name}</h3>
                        <p class="text-muted"><span class="fas fa-euro-sign"></span> Gratuit</p>
                        <p>${article.descript}</p>
                        
                        <c:if test="${not empty PersonConnected}">
                          <p class="text-right"><a class="btn btn-success" href="${DefaultPath}/AddArticleToCart?articleId=${article.id}">Ajouter au panier</a></p>
                        </c:if>
                      </div>
                    </div>
                    <hr class="col-12">
                  </c:forEach>
              </div>
            </div>


    </body>
    </html>