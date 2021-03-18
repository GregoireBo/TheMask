package fr.cesi.TheMask.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public interface ViewInterface {
    /**
     * Commentaire javadoc de doGet.
     * doGet permet d'intercepter les requêtes GET
     * @param request Contient une requête du protocole HTTP
     * @param response Contient la résponse d'une requête HTTP
     */
    void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException;

    /**
     * Commentaire javadoc de doPost.
     * doPost permet d'intercepter les requêtes POST
     * @param request Contient une requête du protocole HTTP
     * @param response Contient la résponse d'une requête HTTP
     */
    void doPost(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException;
}
