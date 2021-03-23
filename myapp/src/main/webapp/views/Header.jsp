<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="${DefaultPath}/Index">${Title}</a>

        <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <c:if test="${PersonConnected.isAdmin}">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="${DefaultPath}/AddArticle">Ajouter un article</a>
                    </li>
                </c:if>
            </ul>
            <div class="my-2 my-lg-0">
                <div class="dropleft">
                    <button class="btn btn-success dropdown-toggle" type="button" data-toggle="dropdown">
                        <i class="fas fa-user"></i>
                    </button>
                    <div class="dropdown-menu">
                        <c:choose>
                            <c:when test="${PersonConnected eq null}">
                                <a class="dropdown-item" href="${DefaultPath}/Signin">Connexion</a>
                                <a class="dropdown-item" href="${DefaultPath}/Signup">Inscription</a>
                            </c:when>
                            <c:otherwise>
                                <a class="dropdown-item" href="${DefaultPath}/Cart">Mon panier</a>
                                <a class="dropdown-item" href="${DefaultPath}/Disconnect">Déconnexion</a>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</header>