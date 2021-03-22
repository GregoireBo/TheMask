<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="fr.cesi.TheMask.model.Cart"%>
<%@ page import="fr.cesi.TheMask.model.Article"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<html>
    <head>

        <style>
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


          <div class="container">
            <div class="row">
              <div class="col-md-3">
                
                    
                    <h4 class="">Recherche</h4>
                    
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Recherche" name="srch-term" id="srch-term">
                        <div class="input-group-btn">
                            <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i>
                            </button>
                        </div>
                    </div>
                    
                    <hr>
                    <ul class="list-group list-group">
                        <h4 class="">Categories</h4>
                        <div><a href="#" class="list-group-item"><span class="badge rounded-pill bg-secondary">X</span> CAT_1 <span class="badge bg-primary">New</span></a></div>
                        <div><a href="#" class="list-group-item"><span class="badge rounded-pill bg-secondary">X</span> CAT_2</a>	</div>
                    </ul>
                    

              </div>
              <div class="col-9">
                  <div class="row">
                    
                    <div class="col-2">
                      <select class="form-control">
                        <option>Les plus en vogues</option>
                        <option>Les moins chers</option>
                        <option>Les plus chers</option>
                        <option>A-Z</option>
                        <option>Z-A</option>
                      </select>
                    </div>
                    
                    <div class="col-10">
                      <div class="btn-group float-end">
                        <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-th"></span></button>
                        <button type="button" class="btn btn-default active"><span class="glyphicon glyphicon-th-list"></span></button>
                        <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-list"></span></button>
                        
                      </div>
                    </div>
                </div>
                
                <hr>
                
                
                <div class="row">
                  <div class="col-4">
                      <a href="#" class=""><img src="http://placehold.it/1280X720" class="img-fluid"></a>
                  </div>
                  <div class="col-8">
                    <h3 class="title">MASQUE_X</h3>
                    <p class="text-muted"><span class="glyphicon glyphicon-euro"></span> XX</p>
                    <p>DESCRIPTION_MASQUE_X</p>
                    
                    <p class="text-muted"><a href="#">AJOUTER_MASQUE_X</a></p>
                    
                  </div>
                </div>
                <hr>
                
                
                
                <ul class="pagination pagination-sm float-end">
                  <li class="page-item"><a  class="page-link" href="#">«</a></li>
                  <li class="page-item active"><a  class="page-link" href="#">X</a></li>
                  <li class="page-item"><a  class="page-link"href="#">X</a></li>
                  <li class="page-item"><a  class="page-link" href="#">»</a></li>
                </ul>
                
                
              </div>
            </div>
          </div>


    </body>
    </html>