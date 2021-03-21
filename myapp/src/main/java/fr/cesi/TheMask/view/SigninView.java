package fr.cesi.TheMask.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.TheMask.controller.PersonController;
import fr.cesi.TheMask.model.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/Signin")
public class SigninView extends ViewBase implements ViewInterface  {

  static final long serialVersionUID = -1;
  private PersonController personController;

  /**
   * Constructor.
   */
  public SigninView() {
    this.personController = new PersonController();
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
      this.processRequest("views/Signin.jsp", request, response);
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
      Person person = new Person();
      person.setEmail(request.getParameter("email"));
      person.setPassword(request.getParameter("password"));

      Person personSaved = personController.verifConnection(person);

      if (personSaved == null) {
        request.setAttribute("email", person.getEmail());
        request.setAttribute("password", person.getPassword());
        request.setAttribute("ErrorMessageList", personController.getErrorMessage());
        this.processRequest("views/Signin.jsp", request, response);
      } else {
        request.getSession().setAttribute(ATTRIBUTE_USER, personSaved);
        response.sendRedirect(DEFAULT_PATH);
      }
    }
}
