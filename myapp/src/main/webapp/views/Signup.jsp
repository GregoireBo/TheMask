<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="fr.cesi.TheMask.model.Example"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<html>
    <head>
        ${Bootstrap}
        <title>${Title} - Sign up</title>
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
                  <h5 class="card-title">${Title} - Enregistrez-vous !</h5>
                  <p class="card-text">Bienvenue sur The Mask ! Merci d'entrer vos informations ci-dessous pour vous inscrire sur notre site de vente et échange de masques ! <br />
                Avec The Mask, Protégez-vous du COVID !</p>
            <c:forEach var = "errorMessage" items = "${ErrorMessageList}">
                <div>${errorMessage}</div>
             </c:forEach>
            
            <form action="" method="POST">
                <label for="fname" class="formcss">Prénom :</label>
                <input type="text" id="firstName" name="firstName" value="${firstName}" class="form-control"><br>

                <label for="lname" class="formcss">Nom :</label>
                <input type="text" id="lastName" name="lastName" value="${lastName}" class="form-control"><br>

                <label for="email" class="formcss">Mail :</label>
                <input type="email" id="email" name="email" value="${email}" class="form-control"><br>

                <label for="password" class="formcss">Password :</label>
                <input type="password" id="password" name="password" value="${password}" class="form-control"><br>

                <button type="submit" class="btn btn-success">Valider</button>
              </form>
        </div></div></center></div></div></div>
    </body>
    </html>