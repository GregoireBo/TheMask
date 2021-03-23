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
        #carouselIndex
        {
            margin-bottom: 10px;
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
        <!--
        <div id="carouselIndex" class="carousel carousel-dark slide" data-bs-ride="carousel">
            <div class="carousel-indicators">
              <button type="button" data-bs-target="#carouselIndex" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
              <button type="button" data-bs-target="#carouselIndex" data-bs-slide-to="1" aria-label="Slide 2"></button>
              <button type="button" data-bs-target="#carouselIndex" data-bs-slide-to="2" aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
              <div class="carousel-item active" data-bs-interval="2000">
                <img src="http://placehold.it/1280X720" class="d-block" alt="...">
                <div class="carousel-caption d-none d-md-block">
                  <h5>First slide label</h5>
                  <p>Some representative placeholder content for the first slide.</p>
                </div>
              </div>
              <div class="carousel-item" data-bs-interval="2000">
                <img src="http://placehold.it/1280X720" class="d-block" alt="...">
                <div class="carousel-caption d-none d-md-block">
                  <h5>Second slide label</h5>
                  <p>Some representative placeholder content for the second slide.</p>
                </div>
              </div>
              <div class="carousel-item">
                <img src="http://placehold.it/1280X720" class="d-block" alt="...">
                <div class="carousel-caption d-none d-md-block">
                  <h5>Third slide label</h5>
                  <p>Some representative placeholder content for the third slide.</p>
                </div>
              </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselIndex"  data-bs-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselIndex"  data-bs-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Next</span>
            </button>
          </div>
        -->
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
            <div class="row">
              <div class="col-12">
                  <div class="row mt-4">
                  <hr>
                  <c:forEach var = "article" items = "${listArticles}"> <!-- A modifier -->
                    <div class="row">

                      <div class="col-5">
                          <a href="${DefaultPath}/Article?id=${article.id}"><img src="data:image/png;base64,${article.getPictureString()}" class="img-fluid"></a>
                      </div>
                      <div class="col-7">
                        <h3 class="title">${article.name}</h3>
                        <p class="text-muted"><span class="fas fa-euro-sign"></span> Gratuit</p>
                        <p>${article.descript}</p>
                        
                        <c:if test="${not empty PersonConnected}">
                          <p class="text-muted"><a class="btn btn-success" href="${DefaultPath}/AddArticleToCart?articleId=${article.id}">Ajouter au panier</a></p>
                        </c:if>
                      </div>
                    </div>
                    <hr>
                  </c:forEach>
              </div>
            </div>
          </div>


    </body>
    </html>