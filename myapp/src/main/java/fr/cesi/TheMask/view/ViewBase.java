package fr.cesi.TheMask.view;

import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public class ViewBase extends HttpServlet {

  private static final long serialVersionUID = 1L;
  protected static final String DEFAULT_PATH = "/myapp";
  protected static final String ATTRIBUTE_USER = "PersonConnected";

    /**
     * Permet d'executer une requête post ou get.
     * @param fileName Nom du fichier à execuer
     * @param request Contient une requête du protocole HTTP
     * @param response Contient la résponse d'une requête HTTP
     */
    protected void processRequest(
      final String fileName,
      final HttpServletRequest request, final HttpServletResponse response)
      throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher(fileName);
        request.setAttribute("Title", "The mask");
        dispatcher.forward(request, response);
    }


}
