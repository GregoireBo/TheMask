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
}
