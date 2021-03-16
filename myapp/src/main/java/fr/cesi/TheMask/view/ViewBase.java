package fr.cesi.TheMask.view;

import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public class ViewBase extends HttpServlet {

  private static final long serialVersionUID = 1L;

    /**
     * Permet d'executer une requête post ou get.
     * @param request Contient une requête du protocole HTTP
     * @param response Contient la résponse d'une requête HTTP
     */
    protected void processRequest(
      final HttpServletRequest request, final HttpServletResponse response)
      throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher(
          "views/index.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Commentaire javadoc de doGet.
     * doGet permet d'intercepter les requêtes GET
     * @param request Contient une requête du protocole HTTP
     * @param response Contient la résponse d'une requête HTTP
     */
    @Override
    protected void doGet(
      final HttpServletRequest request, final HttpServletResponse response)
      throws ServletException, IOException {

        processRequest(request, response);
    }

    /**
     * Commentaire javadoc de doPost.
     * doPost permet d'intercepter les requêtes POST
     * @param request Contient une requête du protocole HTTP
     * @param response Contient la résponse d'une requête HTTP
     */
    @Override
    protected void doPost(
      final HttpServletRequest request, final HttpServletResponse response)
      throws ServletException, IOException {

        processRequest(request, response);
    }
}
