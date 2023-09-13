package com.springpost.project.model;

public class ProductNotFoundException extends RuntimeException {
    
    public ProductNotFoundException (String exception){
        super(exception);
    }
}
