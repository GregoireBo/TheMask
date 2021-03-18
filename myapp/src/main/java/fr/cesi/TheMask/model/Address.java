package fr.cesi.TheMask.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {

   @Id
   @GeneratedValue()
   private int id;

   private String street;
   private String postalCode;
   private String city;

   @Enumerated(EnumType.STRING)
   private Country country;

   public int getId() {
     return this.id;
   }

   public void setId(final int id) {
     this.id = id;
   }

   public String getStreet() {
     return this.street;
   }

   public void setStreet(final String street) {
     this.street = street;
   }

   public String getPostalCode() {
     return this.postalCode;
   }

   public void setPostalCode(final String postalCode) {
     this.postalCode = postalCode;
   }

   public String getCity() {
     return this.city;
   }

   public void setCity(final String city) {
     this.city = city;
   }

   public Country getCountry() {
     return this.country;
   }

   public void setCountry(final Country country) {
     this.country = country;
   }

 }
