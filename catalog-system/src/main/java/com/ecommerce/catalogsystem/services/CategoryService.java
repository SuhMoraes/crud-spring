package com.ecommerce.catalogsystem.services;

import com.ecommerce.catalogsystem.domain.Category;
import com.ecommerce.catalogsystem.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public boolean existsByIdAndName(Long id, String name){
        return categoryRepository.existsByIdAndName(id, name);
    }}
