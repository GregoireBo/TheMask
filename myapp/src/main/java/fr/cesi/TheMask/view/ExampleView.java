package fr.cesi.TheMask.view;

import fr.cesi.TheMask.controller.ExampleController;
import fr.cesi.TheMask.model.Example;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/Example")
public class ExampleView extends ViewBase {

    /**
     * Permet d'executer une requête post ou get.
     * @param request Contient une requête du protocole HTTP
     * @param response Contient la résponse d'une requête HTTP
     */
    @Override
    protected void processRequest(
      final HttpServletRequest request, final HttpServletResponse response)
      throws ServletException, IOException {

        Example oExample = ExampleController.getRandomExample();
        request.setAttribute("ExampleAttribute", oExample);

        RequestDispatcher dispatcher = request.getRequestDispatcher(
          "JSP/Example.jsp");
        dispatcher.forward(request, response);
    }


}
