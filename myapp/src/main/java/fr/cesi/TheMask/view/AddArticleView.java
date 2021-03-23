package fr.cesi.TheMask.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.TheMask.controller.ArticleController;
import fr.cesi.TheMask.model.Article;
import fr.cesi.TheMask.model.Person;
import fr.cesi.TheMask.model.Review;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
      if (request.getSession().getAttribute(ATTRIBUTE_USER) != null) {
        Person personConnected = (Person) request.getSession().getAttribute(ATTRIBUTE_USER);
        if (!personConnected.isIsAdmin()) {
          response.sendRedirect(DEFAULT_PATH + "/Index");
          return;
        }
      } else {
        response.sendRedirect(DEFAULT_PATH + "/Index");
        return;
      }
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
    if (request.getSession().getAttribute(ATTRIBUTE_USER) != null) {
      Person personConnected = (Person) request.getSession().getAttribute(ATTRIBUTE_USER);
      if (!personConnected.isIsAdmin()) {
        response.sendRedirect(DEFAULT_PATH + "/Index");
        return;
      }
    } else {
      response.sendRedirect(DEFAULT_PATH + "/Index");
      return;
    }
    Article article = new Article();
    Person author = new Person();

    Collection<Review> reviews = new ArrayList<Review>();

    author = (Person) request.getSession().getAttribute(ATTRIBUTE_USER);

    article.setPerson(author);
    article.setReviews(reviews);

    List<FileItem> items;
    try {
      items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
      for (FileItem item : items) {
        if (item.isFormField()) {
          String nomChamp = item.getFieldName();
          String valeurChamp = item.getString();
          if (nomChamp.compareTo("name") == 0) {
            article.setName(valeurChamp);
          } else if (nomChamp.compareTo("descr") == 0) {
            article.setDescript(valeurChamp);
          } else if (nomChamp.compareTo("size") == 0) {
            article.setSize(valeurChamp);
          }
        } else {
          InputStream contenuFichier = item.getInputStream();
          if (contenuFichier != null) {
            article.setPicture(IOUtils.toByteArray(contenuFichier));
          }
        }
      }
    } catch (FileUploadException e) {
      // TODO Auto-generated catch block
      System.err.println(e);
      e.printStackTrace();
    }

    Article articleSaved = articleController.addArticle(article);

    if (articleSaved == null) {
      request.setAttribute("name", article.getName());
      request.setAttribute("descr", article.getDescript());
      request.setAttribute("size", article.getSize());
      request.setAttribute("person", article.getPerson());
      request.setAttribute("ErrorMessagelist", articleController.getErrorMessage());
      this.processRequest("views/AddArticle.jsp", request, response);
    } else {
      response.sendRedirect(DEFAULT_PATH + "/Article?id=" + articleSaved.getId());
    }
  }
}
