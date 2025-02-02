package com.ntndev.tmdtbasic.services;

import com.ntndev.tmdtbasic.model.Category;
import com.ntndev.tmdtbasic.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Boolean create(Category category) {
        try {
             categoryRepository.save(category);
             return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Boolean update(Category category) {
        try {
             categoryRepository.save(category);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public Boolean delete(Integer id) {
        try {
             categoryRepository.delete(findById(id));
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public List<Category> searchCategory(String keyword) {
        return categoryRepository.findByCategoryNameContainsIgnoreCase(keyword);
    }

    @Override
    public Page<Category> getAll(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo - 1, 2);

        return categoryRepository.findAll(pageable);
    }

    @Override
    public Page<Category> searchCategory(String keyword, Integer pageNo) {
        List<Category> list = this.searchCategory(keyword);

        Pageable pageable = PageRequest.of(pageNo - 1, 2);

        Integer start = (int) pageable.getOffset();
        Integer end = (pageable.getOffset() + pageable.getPageSize()) > list.size() ? list.size() : (int) (pageable.getOffset() + pageable.getPageSize());

        list = list.subList(start, end);
        return new PageImpl<>(list,pageable, this.searchCategory(keyword).size());
    }
}
