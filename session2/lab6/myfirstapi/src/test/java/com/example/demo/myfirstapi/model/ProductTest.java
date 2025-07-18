package com.example.demo.myfirstapi.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    public void testProductConstructorAndGetters() {
        Product product = new Product("Laptop", 999.99);

        assertNull(product.getId());
        assertEquals("Laptop", product.getName());
        assertEquals(999.99, product.getPrice());
    }

    @Test
    public void testEqualsAndHashCode() {
        Product product1 = new Product(1L, "Phone", 500.0);
        Product product2 = new Product(1L, "Phone", 500.0);
        Product product3 = new Product(2L, "Tablet", 700.0);

        assertEquals(product1, product2);
        assertEquals(product1.hashCode(), product2.hashCode());

        assertNotEquals(product1, product3);
    }

    @Test
    public void testSetters() {
        Product product = new Product("Placeholder", 0.0);

        product.setId(10L);
        product.setName("Monitor");
        product.setPrice(199.99);

        assertEquals(10L, product.getId());
        assertEquals("Monitor", product.getName());
        assertEquals(199.99, product.getPrice());
    }


}