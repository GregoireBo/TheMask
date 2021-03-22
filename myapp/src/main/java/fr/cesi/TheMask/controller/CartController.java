package fr.cesi.TheMask.controller;

import fr.cesi.TheMask.model.Article;
import fr.cesi.TheMask.model.Cart;

import java.util.Collection;


public class CartController extends Persist<Cart> implements ControllerInterface<Cart>  {
    /**
     * Permet d'ajouter un article au panier d'un utilisateur.
     * @param cart Panier auquel on va ajouter l'article
     * @param article Article à ajouter
     */
    public void addArticle(final Cart cart, final Article article) {
        cart.getArticles().add(article);
        this.save(cart);
    }

    @Override
    public Collection<Cart> getAll() {
        return null;
    }

    @Override
    public Cart get(final int id) {
        return null;
    }
}
