package com.productsservice.microservice.service;

import java.util.List;

import com.productsservice.microservice.dto.CategoryDTO;

public interface CategoryService {

	public CategoryDTO addCategory(CategoryDTO categoryDto);

	public CategoryDTO updateCategory(Integer categoryId, CategoryDTO categoryDto);

	public List<CategoryDTO> getAllCategories();

	public CategoryDTO getCategoryById(Integer categoryId);

	public CategoryDTO deleteCategoryById(Integer categoryId);

}
