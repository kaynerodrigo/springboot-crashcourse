package com.example.demo.myfirstapi.repository;

import com.example.demo.myfirstapi.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = new ProductRepository();
    }

    @Test
    void testFindAll() {
        List<Product> products = productRepository.findAll();
        assertEquals(3, products.size());
    }

    @Test
    void testFindByIdExists() {
        Optional<Product> product = productRepository.findById(1L);
        assertTrue(product.isPresent());
        assertEquals("Laptop", product.get().getName());
    }

    @Test
    void testFindByIdNotExists() {
        Optional<Product> product = productRepository.findById(999L);
        assertFalse(product.isPresent());
    }

    @Test
    void testSaveNewProduct() {
        Product newProduct = new Product(null, "Phone", 500.00);
        Product saved = productRepository.save(newProduct);

        assertNotNull(saved.getId());
        assertEquals("Phone", saved.getName());
        assertEquals(4, productRepository.findAll().size());
    }

    @Test
    void testSaveExistingProduct() {
        Product updated = new Product(1L, "Gaming Laptop", 1500.00);
        Product saved = productRepository.save(updated);

        assertEquals(1L, saved.getId());
        assertEquals("Gaming Laptop", saved.getName());
        assertEquals(3, productRepository.findAll().size());
    }
}