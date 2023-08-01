package com.ecommerce.catalogsystem.repository;


import com.ecommerce.catalogsystem.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, Long> {

    boolean existsByIdAndName(Long id, String name);



}
