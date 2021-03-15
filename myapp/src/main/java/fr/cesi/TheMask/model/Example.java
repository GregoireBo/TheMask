package fr.cesi.TheMask.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Example {
   @Id
   @GeneratedValue()
   private int id;
   private String text1;
   private String text2;

   public int getId() {
       return this.id;
    }

    public void setId(final int id) {
       this.id = id;
    }

    public String getText1() {
       return this.text1;
    }

    public void setText1(final String text1) {
       this.text1 = text1;
    }

    public String getText2() {
      return this.text2;
   }

   public void setText2(final String text2) {
      this.text2 = text2;
   }
 }
