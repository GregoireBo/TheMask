package fr.cesi.TheMask.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.cesi.TheMask.controller.ArticleController;

@WebServlet("/Index")
public class IndexView extends ViewBase implements ViewInterface {
    static final long serialVersionUID = -1;

    /**
     * Commentaire javadoc de doGet.
     * doGet permet d'intercepter les requêtes GET
     * @param request Contient une requête du protocole HTTP
     * @param response Contient la résponse d'une requête HTTP
     */
    public void doGet(
    final HttpServletRequest request, final HttpServletResponse response)
    throws ServletException, IOException {
        ArticleController articleController = new ArticleController();
        request.setAttribute("listArticles", articleController.getAll());
        this.processRequest("views/Index.jsp", request, response);
    }

    /**
     * Commentaire javadoc de doPost.
     * doPost permet d'intercepter les requêtes POST
     * @param request Contient une requête du protocole HTTP
     * @param response Contient la résponse d'une requête HTTP
     */
    public void doPost(
    final HttpServletRequest request, final HttpServletResponse response)
    throws ServletException, IOException {
        this.doGet(request, response);
    }
}
