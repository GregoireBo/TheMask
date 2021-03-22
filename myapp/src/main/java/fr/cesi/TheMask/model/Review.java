package fr.cesi.TheMask.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Review {

   @Id
   @GeneratedValue()
   private int id;

   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "article_id")
   private Article article;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "person_id")
   private Person person;
   private int note;

   public int getId() {
       return this.id;
   }

   public void setId(final int id) {
       this.id = id;
   }

   public Article getArticle() {
       return this.article;
   }

   public void setArticle(final Article article) {
       this.article = article;
   }

   public Person getPerson() {
       return this.person;
   }

   public void setPerson(final Person person) {
       this.person = person;
   }

   public int getNote() {
       return this.note;
   }

   public void setNote(final int note) {
       this.note = note;
   }

 }
