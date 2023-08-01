package com.ecommerce.catalogsystem.resources;

import com.ecommerce.catalogsystem.domain.Category;
import com.ecommerce.catalogsystem.services.CategoryService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/category")
@Slf4j
public class CategoryResource {

    @Autowired
    private CategoryService service;

    public CategoryResource(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid Category category) {
        if(category.getId() == null || category.getName() == null) {
            log.info("::: CATEGORY INVALID ::: " + category);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CATEGORY INVALID");
        }

        if(service.existsByIdAndName(category.getId(), category.getName())) {
            log.info("::: CATEGORY EXITED ::: " + category.getName(), category.getId());
            return ResponseEntity.status(HttpStatus.FOUND).body("::: CATEGORY EXITED :::");
        }

        log.info("::: CATEGORY CREATED ::: " + category.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveCategory(category));
    }

}
