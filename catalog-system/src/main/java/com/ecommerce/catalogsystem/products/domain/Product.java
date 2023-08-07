package com.ecommerce.catalogsystem.products.domain;

import com.ecommerce.catalogsystem.category.domain.Category;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="tb_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private UUID id;

    private String name;
    private String description;
    private String price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private Long stock_quantity;

    public Product() {
    }

    public Product(UUID id, String name, String description, String price, Category category, Long stock_quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.stock_quantity = stock_quantity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(Long stock_quantity) {
        this.stock_quantity = stock_quantity;
    }
}
