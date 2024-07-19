package com.ntndev.tmdtbasic.repository;

import com.ntndev.tmdtbasic.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findByCategoryNameContainsIgnoreCase(String keyword);
}
