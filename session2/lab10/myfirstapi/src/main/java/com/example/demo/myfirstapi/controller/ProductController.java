package com.example.demo.myfirstapi.controller;

import com.example.demo.myfirstapi.model.Product;
import com.example.demo.myfirstapi.repository.ProductRepository;
import org.springframework.http.HttpStatus; // <-- Import this!
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping; // <-- Import this!
import org.springframework.web.bind.annotation.RequestBody; // <-- Import this!
import org.springframework.web.bind.annotation.ResponseStatus; // <-- Import this (optional, for @ResponseStatus)
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional; // <-- Import this!

@RestController
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}") // {id} is a path variable
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        // Find the product by ID using the repository
        Optional<Product> product = productRepository.findById(id);

        // Check if the product was found
        if (product.isPresent()) {
            // If found, return it with HTTP 200 OK
            return ResponseEntity.ok(product.get()); // .get() gets the Product from Optional
        } else {
            // If not found, return HTTP 404 Not Found
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/products") // Maps HTTP POST requests to /products
    @ResponseStatus(HttpStatus.CREATED) // Optional: Returns 201 Created by default for POST success
    public Product createProduct(@RequestBody Product newProduct) {
        // newProduct object automatically populated from JSON in request body
        return productRepository.save(newProduct); // Save and return the saved product (with its new ID)
    }
}