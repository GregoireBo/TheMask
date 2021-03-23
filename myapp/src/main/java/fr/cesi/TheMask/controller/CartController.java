package fr.cesi.TheMask.controller;

import fr.cesi.TheMask.model.Article;
import fr.cesi.TheMask.model.Cart;
import fr.cesi.TheMask.model.Person;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class CartController extends Persist<Cart> implements ControllerInterface<Cart>  {

    protected void finalize() throws Throwable {
        super.finalize();
    }
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

        if (checkIfExistInCart(person.getCart().getId(), articleId)) {
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
        } else {
            this.addError("L'article existe déjà dans le panier");
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

    private boolean checkIfExistInCart(final int cartId, final int articleId) {
        EntityManager em = getEntityManager();
        TypedQuery<Integer> q =
            em.createQuery("SELECT c.id FROM Cart c"
            + " inner join c.articles a"
            + " WHERE c.id = ?1 AND a.id = ?2", Integer.class);
        q.setParameter(1, cartId);
        q.setParameter(2, articleId);

        return q.getResultList().isEmpty();
    }
}
