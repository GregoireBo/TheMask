package fr.cesi.TheMask.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/DeleteArticleFromCart")
public class DeleteArticleFromCartView extends ViewBase implements ViewInterface {

  static final long serialVersionUID = -1;
  static final int TEST_ID = 7;

  /**
   * Constructor.
   */
  public DeleteArticleFromCartView() {
  }

    /**
   * Commentaire javadoc de doGet.
   * doGet permet d'intercepter les requêtes GET
   * @param request Contient une requête du protocole HTTP
   * @param response Contient la résponse d'une requête HTTP
   */
  public void doGet(
    final HttpServletRequest request, final HttpServletResponse response)
    throws ServletException, IOException {
      response.sendRedirect(DEFAULT_PATH + "/Cart");
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
