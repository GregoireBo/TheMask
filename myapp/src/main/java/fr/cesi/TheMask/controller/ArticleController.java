package fr.cesi.TheMask.controller;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.cesi.TheMask.model.Article;

public class ArticleController extends Persist<Article> implements ControllerInterface<Article>  {

    @Override
    public Collection<Article> getAll() {
        EntityManager em = getEntityManager();
        TypedQuery<Article> q =
            em.createQuery("SELECT a FROM Article a", Article.class);

        return q.getResultList();
    }

    @Override
    public Article get(final int id) {
        EntityManager em = getEntityManager();
        TypedQuery<Article> q =
            em.createQuery("SELECT a FROM Article a WHERE a.id = ?1", Article.class);
        q.setParameter(1, id);

        return q.getSingleResult();
    }

    /**
     * Permet d'ajouter un article après avoir fait tout les controlles nécéssaires.
     * @param article objet article à enregistrer
     * @return true si réussi, false sinon
     */
    public Article addArticle(final Article article) {
        this.clearError();
        this.clearInfo();

        Article articleResult = null;
        boolean controlOK = true;

        if (article.getName() == "") {
            this.addError("Le nom est obligatoire");
            controlOK = false;
        }
        if (article.getSize() == "") {
            this.addError("La taille est obligatoire");
            controlOK = false;
        }

        if (controlOK) {
            articleResult = this.save(article);
            this.addInfo("Enregistrement réussi");
        }
        return articleResult;
    }
}
