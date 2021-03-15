package fr.cesi.TheMask.view;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/Example")
public class ExampleView extends ViewBase {

  static final long serialVersionUID = -1;
    /**
     * Permet d'executer une requête post ou get.
     * @param request Contient une requête du protocole HTTP
     * @param response Contient la résponse d'une requête HTTP
     */
    @Override
    protected void processRequest(
      final HttpServletRequest request, final HttpServletResponse response)
      throws ServletException, IOException {

        //Example oExample = ExampleController.getRandomExample();
        //request.setAttribute("ExampleAttribute", oExample);
        //test();
        RequestDispatcher dispatcher = request.getRequestDispatcher(
          "views/Example.xhtml");
        dispatcher.forward(request, response);
    }
/*
    private void test() {
      EntityManager em = Persistence.createEntityManagerFactory("pu").createEntityManager();
      Example ex = ExampleController.getRandomExample();
      em.getTransaction().begin();
      em.merge(ex);
      em.getTransaction().commit();
    }
*/
}
