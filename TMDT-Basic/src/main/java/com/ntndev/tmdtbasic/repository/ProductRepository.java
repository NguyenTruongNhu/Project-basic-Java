package com.ntndev.tmdtbasic.repository;

import com.ntndev.tmdtbasic.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
