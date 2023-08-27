package com.suhmoraes.javaspringexpert.repositories;

import com.suhmoraes.javaspringexpert.entities.Product;
import com.suhmoraes.javaspringexpert.factory.FactoryTest;
import com.suhmoraes.javaspringexpert.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.Instant;
import java.util.Optional;

@DataJpaTest
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository repository;

    private long existingId;
    private long nonExistingId;
    private long countTotalProducts;

    @BeforeEach
    void setUp() throws Exception {
        existingId = 1L;
        nonExistingId = 100L;
        countTotalProducts = 25L;
    }

    @Test
    void findBydIDShouldReturnOptionalProductWhenIdExists(){
        Optional<Product> result = repository.findById(existingId);
        Assertions.assertTrue(result.isPresent());
    }

    @Test
    void findBydIDShouldReturnOptionalProductWhenIdDoesNotExists(){
        Optional<Product> result = repository.findById(nonExistingId);
        Assertions.assertFalse(result.isPresent());
    }

    @Test
    void saveShouldPersistWithAutoIncrementWhenIdIsNull(){
        Product product = FactoryTest.createProduct();
        product.setId(null);

        product = repository.save(product);

        Assertions.assertNotNull(product.getId());
        Assertions.assertEquals(countTotalProducts + 1, product.getId());
    }

    @Test
    @DisplayName("Delete Should Delete Object When Id Exists")
    void deleteShouldDeleteObjectWhenIdExists(){

        repository.deleteById(existingId);

        Optional<Product> result = repository.findById(existingId);
        Assertions.assertFalse(result.isPresent());
    }


}
