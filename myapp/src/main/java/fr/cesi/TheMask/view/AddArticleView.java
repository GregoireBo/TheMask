package fr.cesi.TheMask.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import fr.cesi.TheMask.controller.ArticleController;
import fr.cesi.TheMask.model.Article;
import fr.cesi.TheMask.model.Person;
import fr.cesi.TheMask.model.Review;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

@WebServlet("/AddArticle")
public class AddArticleView extends ViewBase implements ViewInterface {
  static final long serialVersionUID = -1;
  private ArticleController articleController;

  /**
   * Constructor.
   */
  public AddArticleView() {
    this.articleController = new ArticleController();
  }

  /**
   * Commentaire javadoc de doGet. doGet permet d'intercepter les requêtes GET
   *
   * @param request  Contient une requête du protocole HTTP
   * @param response Contient la résponse d'une requête HTTP
   */
  public void doGet(final HttpServletRequest request, final HttpServletResponse response)
      throws ServletException, IOException {
    this.processRequest("views/AddArticle.jsp", request, response);
  }

  /**
   * Commentaire javadoc de doPost. doPost permet d'intercepter les requêtes POST
   *
   * @param request  Contient une requête du protocole HTTP
   * @param response Contient la résponse d'une requête HTTP
   */
  public void doPost(final HttpServletRequest request, final HttpServletResponse response)
      throws ServletException, IOException {
    Article article = new Article();
    Person author = new Person();

    Collection<Review> reviews = new ArrayList<Review>();

    author = (Person) request.getSession().getAttribute(ATTRIBUTE_USER);

    article.setName(request.getParameter("name"));
    article.setPerson(author);
    article.setReviews(reviews);
    article.setDescript(request.getParameter("descr"));
    article.setSize(request.getParameter("size"));

    Article articleSaved = articleController.addArticle(article);
    getFile(request);
    if (articleSaved == null) {
      request.setAttribute("name", article.getName());
      request.setAttribute("descr", article.getDescript());
      request.setAttribute("size", article.getSize());
      request.setAttribute("person", article.getPerson());
      request.setAttribute("ErrorMessagelist", articleController.getErrorMessage());
      this.processRequest("views/AddArticle.jsp", request, response);
    } else {
      response.sendRedirect(DEFAULT_PATH);
    }
  }

  private void getFile(final HttpServletRequest request) throws IOException, ServletException {
    Part filePart = request.getPart("fileToUpload");

    // get the InputStream to store the file somewhere
    InputStream fileInputStream = filePart.getInputStream();

    // for example, you can copy the uploaded file to the server
    // note that you probably don't want to do this in real life!
    // upload it to a file host like S3 or GCS instead
    File fileToSave = new File("WebContent/uploaded-files/" + filePart.getSubmittedFileName());
  }
}
