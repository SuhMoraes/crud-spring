package com.suhmoraes.javaspringexpert.repository;

import com.suhmoraes.javaspringexpert.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
