package com.springpost.project.model;

import java.net.URI;

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

       URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedProduct.getProductId()).toUri();

		return ResponseEntity.created(location).build();
    }

    @PutMapping("/products/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Product product, @PathVariable long productId) {

		Optional<Product> productOptional = prodRep.findById(productId);

		if (!productOptional.isPresent())
			return ResponseEntity.notFound().build();

		product.setProductId(productId);
		
		prodRep.save(product);

		return ResponseEntity.noContent().build();
	}

	@GetMapping("/productDetails/{name}")
	public ResponseEntity<List<Product>> findData(@PathVariable ("productName") String value){
		List<Product> productList = prodRep.findByName(value);
		return ResponseEntity.ok(productList);
	}

    @GetMapping("/productDetails/{price}")
    public ResponseEntity <List<Product>> findPrice(@PathVariable ("productPrice") double value){
        List<Product> productList = prodRep.findAllOrderByProductPriceAsc(value);
        return ResponseEntity.ok(productList);
    }
}


