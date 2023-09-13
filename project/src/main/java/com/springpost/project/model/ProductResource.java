package com.springpost.project.model;

import java.net.URL;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class ProductResource {
    
    @Autowired
    private ProductRepository prodRep;

    @GetMapping("/products")
    public List<Product> retrieveAllProducts(){
        return prodRep.findAll();
    }

    @GetMapping("/products/{id}")
    public Product retrieveProduct(@PathVariable Long id){
        Optional <Product> product = prodRep.findById(id);

        if (!product.isPresent()){
            throw new ProductNotFoundException("id- " + id);
        }

        return product.get();
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id){
        prodRep.deleteById(id);
    }

    @PostMapping("/products")
    public ResponseEntity<Object> createProduct(@RequestBody Product product){
       Product savedProduct = prodRep.save(product);

       URL location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedProduct.getProductId()).toUri();

		return ResponseEntity.created(location).build();
    }

}
