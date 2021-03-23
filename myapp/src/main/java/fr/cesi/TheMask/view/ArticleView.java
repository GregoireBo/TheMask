package fr.cesi.TheMask.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import fr.cesi.TheMask.controller.ArticleController;
import fr.cesi.TheMask.model.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/Article")
public class ArticleView extends ViewBase implements ViewInterface {
  static final long serialVersionUID = -1;

  private ArticleController articleController;
  private Article article;
  /**
   * Constructor.
   */
  public ArticleView() {
    this.articleController = new ArticleController();
  }

  /**
   * Commentaire javadoc de doGet. doGet permet d'intercepter les requêtes GET
   *
   * @param request  Contient une requête du protocole HTTP
   * @param response Contient la résponse d'une requête HTTP
   */
  public void doGet(final HttpServletRequest request, final HttpServletResponse response)
      throws ServletException, IOException {

    article = this.articleController.get(Integer.parseInt(request.getParameter("id")));
    request.setAttribute("article", article);
    this.processRequest("views/Article.jsp", request, response);
  }

  /**
   * Commentaire javadoc de doPost. doPost permet d'intercepter les requêtes POST
   *
   * @param request  Contient une requête du protocole HTTP
   * @param response Contient la résponse d'une requête HTTP
   */
  public void doPost(final HttpServletRequest request, final HttpServletResponse response)
      throws ServletException, IOException {
    }
}
