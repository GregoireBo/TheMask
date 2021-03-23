package fr.cesi.TheMask.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/Disconnect")
public class DisconnectView extends ViewBase implements ViewInterface {

  static final long serialVersionUID = -1;

  /**
   * Constructor.
   */
  public DisconnectView() {
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
        request.getSession().removeAttribute(ATTRIBUTE_USER);
        response.sendRedirect(DEFAULT_PATH + "/Index");
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
