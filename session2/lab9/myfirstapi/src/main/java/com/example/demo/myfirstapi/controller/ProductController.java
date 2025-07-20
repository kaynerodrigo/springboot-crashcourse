package com.example.demo.myfirstapi.controller;

import com.example.demo.myfirstapi.model.Product;
import com.example.demo.myfirstapi.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController // This annotation makes it a REST controller
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}") //id is a path variable
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        // FInd the product by ID using the repository
        Optional<Product> product = productRepository.findById(id);

        //check if the product was found
        if(product.isPresent()) {
            return ResponseEntity.ok(product.get()); // .get() gets the Product from Optional
        } else {
            return  ResponseEntity.notFound().build();
        }
    }
}
