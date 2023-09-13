package com.springpost.project.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "Product")
public class Product {
     @Id
     @GeneratedValue
     private Long productId;
     private String productName;
     private int productQuantity;
     private double productPrice;
     private double productDiscount;

     public Product(){
         super();
     }


     public Product(Long productId, String productName, int productQuantity, double productPrice, double productDiscount) {
          super();
          this.productId = productId;
          this.productName = productName;
          this.productQuantity = productQuantity;
          this.productPrice = productPrice;
          this.productDiscount = productDiscount;
     }

     public Long getProductId() {
          return this.productId;
     }

     public void setProductId(Long productId) {
          this.productId = productId;
     }

     public String getProductName() {
          return this.productName;
     }

     public void setProductName(String productName) {
          this.productName = productName;
     }

     public int getProductQuantity() {
          return this.productQuantity;
     }

     public void setProductQuantity(int productQuantity) {
          this.productQuantity = productQuantity;
     }

     public double getProductPrice() {
          return this.productPrice;
     }

     public void setProductPrice(double productPrice) {
          this.productPrice = productPrice;
     }

     public double getProductDiscount() {
          return this.productDiscount;
     }

     public void setProductDiscount(double productDiscount) {
          this.productDiscount = productDiscount;
     }

     public Product productId(Long productId) {
          setProductId(productId);
          return this;
     }

     public Product productName(String productName) {
          setProductName(productName);
          return this;
     }

     public Product productQuantity(int productQuantity) {
          setProductQuantity(productQuantity);
          return this;
     }

     public Product productPrice(double productPrice) {
          setProductPrice(productPrice);
          return this;
     }

     public Product productDiscount(double productDiscount) {
          setProductDiscount(productDiscount);
          return this;
     }

     @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Product)) {
            return false;
        }
        Product product = (Product) o;
        return productId == product.productId && Objects.equals(productName, product.productName) && productQuantity == product.productQuantity && productPrice == product.productPrice && productDiscount == product.productDiscount;
     }

     @Override
     public int hashCode() {
          return Objects.hash(productId, productName, productQuantity, productPrice, productDiscount);
     }

     @Override
     public String toString() {
          return "{" +
               " productId='" + getProductId() + "'" +
               ", productName='" + getProductName() + "'" +
               ", productQuantity='" + getProductQuantity() + "'" +
               ", productPrice='" + getProductPrice() + "'" +
               ", productDiscount='" + getProductDiscount() + "'" +
               "}";
     }
     
}
