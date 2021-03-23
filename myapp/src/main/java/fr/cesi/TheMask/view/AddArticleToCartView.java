package fr.cesi.TheMask.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.TheMask.controller.CartController;
import fr.cesi.TheMask.model.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/AddArticleToCart")
public class AddArticleToCartView extends ViewBase implements ViewInterface {

  static final long serialVersionUID = -1;
  private CartController cartController;
  static final int TEST_ID = 7;

  /**
   * Constructor.
   */
  public AddArticleToCartView() {
    this.cartController = new CartController();
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
      Person personConnected = (Person) request.getSession().getAttribute(ATTRIBUTE_USER);

      int articleId = Integer.parseInt(request.getParameter("articleId"));
      String type = request.getParameter("type");
      Boolean isDelete = false;
      Boolean isClear = false;

      if (type != null) {
        isDelete = (type.equals("delete"));
        isClear = (type.equals("clear"));
      }

      if (personConnected != null && articleId != 0) {
        if (isDelete) {
          cartController.deleteArticle(personConnected, articleId);
        } else if (isClear) {
          cartController.clearCart(personConnected.getCart());
        } else {
          cartController.addArticle(personConnected, articleId);
        }
      }
      response.setHeader("ErrorMessage", cartController.getErrorMessage().toString());
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
