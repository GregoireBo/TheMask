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
  private static final String BOOSTRAP_CSS = "<link rel=\"stylesheet\" "
      + "href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" "
      + "integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" "
      + "crossorigin=\"anonymous\">";
  private static final String BOOSTRAP_JS = "<script "
      + "src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" "
      + "integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" "
      + "crossorigin=\"anonymous\"></script> "
      + "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" "
      + "integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" "
      + "crossorigin=\"anonymous\"></script> "
      + "<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" "
      + "integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" "
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
