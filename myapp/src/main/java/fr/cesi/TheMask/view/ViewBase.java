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

  //BOOTSTRAP
  private static final String BOOSTRAP_CSS = "<link "
        + "href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css\" "
        + "rel=\"stylesheet\" "
        + "integrity=\"sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl\" "
        + "crossorigin=\"anonymous\">";
  private static final String BOOSTRAP_JS = "<script "
        + "src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js\" "
        + "integrity=\"sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0\" "
        + "crossorigin=\"anonymous\"></script>";
  private static final String FONT_AWESOME = "<script "
        + "src=\"https://kit.fontawesome.com/5ee7cadfc7.js\" "
        + "crossorigin=\"anonymous\"></script>";

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
        String bootstrap = "";
        bootstrap += BOOSTRAP_CSS;
        bootstrap += System.getProperty("line.separator");
        bootstrap += BOOSTRAP_JS;
        bootstrap += System.getProperty("line.separator");
        bootstrap += FONT_AWESOME;

        request.setAttribute("DefaultPath", DEFAULT_PATH);
        request.setAttribute("Bootstrap", bootstrap);
        request.setAttribute("Title", "The mask");
        request.setAttribute(ATTRIBUTE_USER, request.getSession().getAttribute(ATTRIBUTE_USER));

        RequestDispatcher dispatcher = request.getRequestDispatcher(fileName);
        dispatcher.forward(request, response);
    }


}
