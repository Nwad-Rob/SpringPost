package com.springpost.project.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{
    // SELECT * FROM Product where productName = ?
    public List<Product> findByName(String ProductName);

    //SELECT * FROM Product WHERE productId = ? and productName= ?
    public Product findByIdAndName ( int ProductId, String ProductName);

    //SELECT * FROM Product ORDER BY productPrice ASC
    public  List<Product> findAllOrderByProductPriceAsc(double productPrice); 
 
}
