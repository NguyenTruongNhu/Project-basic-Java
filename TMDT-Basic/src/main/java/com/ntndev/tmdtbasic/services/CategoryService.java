package com.ntndev.tmdtbasic.services;

import com.ntndev.tmdtbasic.model.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Boolean create(Category category);
    Category findById(Integer id);
    Boolean update(Category category);
    Boolean delete(Integer id);
    List<Category> searchCategory(String keyword);

    Page<Category> getAll(Integer pageNo);

    Page<Category> searchCategory(String keyword, Integer pageNo);

}
