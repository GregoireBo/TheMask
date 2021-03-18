package fr.cesi.TheMask.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.TheMask.controller.ExampleController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/Example")
public class ExampleView extends ViewBase implements ViewInterface {

  static final long serialVersionUID = -1;
  private ExampleController exampleController;

  /**
   * Constructor.
   */
  public ExampleView() {
    this.exampleController = new ExampleController();
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
      this.processRequest("views/Example.jsp", request, response);
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
      this.processRequest("views/Example.jsp", request, response);
    }
}
