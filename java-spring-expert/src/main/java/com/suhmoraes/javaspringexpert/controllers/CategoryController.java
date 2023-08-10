package com.suhmoraes.javaspringexpert.controllers;

import com.suhmoraes.javaspringexpert.domain.Category;
import com.suhmoraes.javaspringexpert.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<List<Category>> findaAll() {
        List<Category> list = categoryService.findAll();
        return ResponseEntity.ok().body(list);
    }
}
