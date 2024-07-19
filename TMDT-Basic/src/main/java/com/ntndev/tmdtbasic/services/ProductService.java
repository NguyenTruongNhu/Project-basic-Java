package com.ntndev.tmdtbasic.services;

import com.ntndev.tmdtbasic.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Boolean create(Product product);
    Product findById(Integer id);
    Boolean update(Product product);
    Boolean delete(Integer id);
}
