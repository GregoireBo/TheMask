package fr.cesi.TheMask.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Cart {

   @Id
   @GeneratedValue()
   private int id;

   @ManyToMany(cascade = CascadeType.ALL)
   private Collection<Article> articles;

   public int getId() {
       return this.id;
   }

   public void setId(final int id) {
       this.id = id;
   }

   public Collection<Article> getArticles() {
       return this.articles;
   }

   public void setArticles(final Collection<Article> articles) {
       this.articles = articles;
   }

   /**
    * Ajoute un article au panier.
    * @param article
    */
   public void addArticle(final Article article) {
       this.articles.add(article);
   }

 }
