package com.suhmoraes.javaspringexpert.factory;

import com.suhmoraes.javaspringexpert.dto.ProductDTO;
import com.suhmoraes.javaspringexpert.entities.Category;
import com.suhmoraes.javaspringexpert.entities.Product;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class FactoryTest {

    public static Product createProduct() {
        Category electronicsCategory = new Category(2L, "Electronics");
        Set<Category> categories = new HashSet<>();
        categories.add(electronicsCategory);

        Product product = new Product(1L, "Phone", "Good Phone", 800.0, "https://img.com/img.png", Instant.now(), categories);

        return product;
    }

    public static ProductDTO createProductDTO(){
        Product product = createProduct();
        return  new ProductDTO(product, product.getCategories());
    }
}

