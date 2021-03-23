package fr.cesi.TheMask.model;

import org.apache.commons.codec.binary.Base64;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Article {
   private static final int DESCRIPT_SIZE = 5000;

   @Id
   @GeneratedValue()
   private int id;

   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "person_id")
   private Person person;

   private String name;
   @Column(length = DESCRIPT_SIZE)
   private String descrit;
   private String size;
   private byte[] picture;

   @OneToMany
   private Collection<Review> reviews;

   public int getId() {
      return this.id;
   }

   public void setId(final int id) {
      this.id = id;
   }

   public Person getPerson() {
      return this.person;
   }

   public void setPerson(final Person person) {
      this.person = person;
   }

   public String getName() {
      return this.name;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public String getDescript() {
      return this.descrit;
   }

   public void setDescript(final String descrit) {
      this.descrit = descrit;
   }

   public String getSize() {
      return this.size;
   }

   public void setSize(final String size) {
      this.size = size;
   }

   public byte[] getPicture() {
      return this.picture;
   }

   public void setPicture(final byte[] picture) {
      this.picture = picture;
   }

   public Collection<Review> getReviews() {
      return this.reviews;
   }

   public void setReviews(final Collection<Review> reviews) {
      this.reviews = reviews;
   }

   /**
    * Permet de récupérer l'image au format string base64.
    * @return string
    */
   public String getPictureString() {
      return "data:image/png;base64," + Base64.encodeBase64String(this.getPicture());
   }
 }
