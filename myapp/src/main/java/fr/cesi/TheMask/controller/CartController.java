package fr.cesi.TheMask.controller;

import fr.cesi.TheMask.model.Article;
import fr.cesi.TheMask.model.Cart;
import fr.cesi.TheMask.model.Person;

import java.util.Collection;
import java.util.Iterator;

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
        CartController cartController = new CartController();
        if (person.getCart() == null) {
            person.setCart(new Cart());
        }

        if (!checkIfExistInCart(person.getCart(), articleId)) {
            ArticleController articleController = new ArticleController();
            Article article = articleController.get(articleId);
            if (article != null) {
                person.addArticleToCart(article);
                cartController.save(person.getCart());
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

    /**
     * Permet de supprimer un article d'un utilisateur.
     * @param person person auquel on va ajouter l'article
     * @param articleId Id de l'article à ajouter
     */
    public boolean deleteArticle(final Person person, final int articleId) {
        PersonController personController = new PersonController();
        Iterator<Article> i = person.getCart().getArticles().iterator();
        Article article = new Article();
        while (i.hasNext()) {
            article = i.next();
           if (article.getId() == articleId) {
              i.remove();
              personController.save(person);
              break;
           }
        }
        return true;
    }

    /**
     * Permet de supprimer un article d'un utilisateur.
     * @param cart que on va clear
     */
    public boolean clearCart(final Cart cart) {
        CartController cartController = new CartController();
        cart.clear();
        cartController.save(cart);
        return true;
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

    private boolean checkIfExistInCart(final Cart cart, final int articleId) {
        for (Article article : cart.getArticles()) {
            if (article.getId() == articleId) {
                return true;
            }
        }
        return false;
    }
}
