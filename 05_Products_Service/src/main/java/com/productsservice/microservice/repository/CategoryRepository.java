package com.productsservice.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productsservice.microservice.entity.Category;

public interface CategoryRepository  extends JpaRepository<Category, Integer>{

	boolean existsByCategory(String category);
}
