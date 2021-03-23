package fr.cesi.TheMask.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cart")
public class CartView extends ViewBase implements ViewInterface {
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
        if (request.getSession().getAttribute(ATTRIBUTE_USER) == null) {
            response.sendRedirect(DEFAULT_PATH + "/Index");
          } else {
            this.processRequest("views/Cart.jsp", request, response);
          }
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
        doGet(request, response);
    }
}
