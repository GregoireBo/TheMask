package fr.cesi.TheMask.view;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.TheMask.controller.ExampleController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/Example")
public class ExampleView extends ViewBase {

  static final long serialVersionUID = -1;
  private ExampleController exampleController;

  /**
   * Constructor.
   */
  public ExampleView() {
    this.exampleController = new ExampleController();
  }

  /**
   * Permet d'executer une requête post ou get.
   * @param request Contient une requête du protocole HTTP
   * @param response Contient la résponse d'une requête HTTP
   */
  @Override
  protected void processRequest(
    final HttpServletRequest request, final HttpServletResponse response)
    throws ServletException, IOException {

      request.setAttribute("ExampleListAttribute", this.exampleController.getAll());
      RequestDispatcher dispatcher = request.getRequestDispatcher(
        "views/Example.jsp");
      dispatcher.forward(request, response);
  }
}
