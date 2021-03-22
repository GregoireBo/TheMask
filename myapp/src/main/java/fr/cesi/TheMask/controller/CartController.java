package fr.cesi.TheMask.controller;

import fr.cesi.TheMask.model.Article;
import fr.cesi.TheMask.model.Cart;
import fr.cesi.TheMask.model.Person;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class CartController extends Persist<Cart> implements ControllerInterface<Cart>  {
    /**
     * Permet d'ajouter un article au panier d'un utilisateur.
     * @param person person auquel on va ajouter l'article
     * @param articleId Id de l'article à ajouter
     */
    public boolean addArticle(final Person person, final int articleId) {
        PersonController personController = new PersonController();
        if (person.getCart() == null) {
            person.setCart(new Cart());
        }

        ArticleController articleController = new ArticleController();
        Article article = articleController.get(articleId);
        if (article != null) {
            person.addArticleToCart(article);
            personController.save(person);
            return true;
        } else {
            this.addError("Article was not found");
            return false;
        }
    }

    @Override
    public Collection<Cart> getAll() {
        return null;
    }

    @Override
    public Cart get(final int id) {
        EntityManager em = getEntityManager();
        TypedQuery<Cart> q =
            em.createQuery("SELECT c FROM Cart c WHERE c.id = ?1", Cart.class);
        q.setParameter(1, id);
        return q.getSingleResult();
    }
}
