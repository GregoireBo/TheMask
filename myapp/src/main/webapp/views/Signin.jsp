<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="fr.cesi.TheMask.model.Example"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<html>
    <head>
        ${Bootstrap}
        <title>${Title} - Sign in</title> 
        <link rel="stylesheet" href="CSS/signin.css">
    </head>
    <body>
        <%@include file="Header.jsp" %>
        <div class="container">
            <div class="row">
              <div class="col-sm">
                <center><div class="card" style="width: 400px; margin-top:30px;">
                <center><img src="img/logo.png" class="card-img-top signin_img" /></center>
                <div class="card-body">
                  <h5 class="card-title">${Title} - Connectez-vous</h5>
                  <p class="card-text">En cas d'oubli de votre mot de passe, merci d'envoyer un email à contact@themask.com</p>
            <c:forEach var = "errorMessage" items = "${ErrorMessageList}">
                <div>${errorMessage}</div>
             </c:forEach>
            <form action="" method="POST">

              <label for="email" class="formcss">E-mail :</label>
              <input type="email" id="email" name="email" value="${email}"><br><br />

              <label for="password" class="formcss">Password :</label>
              <input type="password" id="password" name="password" value="${password}"><br /><br />

                <button type="submit" class="btn btn-success" >Valider</button>
              </form>
              </div></div></center>
            </div>
          </div>
          </div>
    </body>
</html>