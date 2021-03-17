package fr.cesi.TheMask.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Person {

   @Id
   @GeneratedValue()
   private int id;

   private boolean isAdmin;
   private String phoneNumber;
   private String firstName;
   private String lastName;

   @Column(unique = true)
   private String email;

   private String password;

   @OneToOne
   @JoinColumn(name = "adress_id")
   private Address address;

   @OneToOne
   private Cart cart;

   public int getId() {
       return this.id;
   }

   public void setId(final int id) {
       this.id = id;
   }

   public boolean isIsAdmin() {
       return this.isAdmin;
   }

   public void setIsAdmin(final boolean isAdmin) {
       this.isAdmin = isAdmin;
   }

   public String getPhoneNumber() {
       return this.phoneNumber;
   }

   public void setPhoneNumber(final String phoneNumber) {
       this.phoneNumber = phoneNumber;
   }

   public String getFirstName() {
       return this.firstName;
   }

   public void setFirstName(final String firstName) {
       this.firstName = firstName;
   }

   public String getLastName() {
       return this.lastName;
   }

   public void setLastName(final String lastName) {
       this.lastName = lastName;
   }

   public String getEmail() {
       return this.email;
   }

   public void setEmail(final String email) {
       this.email = email;
   }

   public String getPassword() {
       return this.password;
   }

   public void setPassword(final String password) {
       this.password = password;
   }

   public Address getAddress() {
       return this.address;
   }

   public void setAddress(final Address address) {
       this.address = address;
   }

   public Cart getCart() {
       return this.cart;
   }

   public void setCart(final Cart cart) {
       this.cart = cart;
   }

 }
