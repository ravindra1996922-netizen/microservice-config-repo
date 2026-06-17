package com.productsservice.microservice.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.productsservice.microservice.dto.CategoryDTO;
import com.productsservice.microservice.entity.Category;
import com.productsservice.microservice.exception.ProductServiceException;
import com.productsservice.microservice.mapper.CategoryMapper;
import com.productsservice.microservice.repository.CategoryRepository;
import com.productsservice.microservice.service.CategoryService;
@Service
public class CategoryServiceIMPL  implements CategoryService{

	@Autowired
	CategoryRepository categoryRepository;
	
	
	
	@Override
	public CategoryDTO addCategory(CategoryDTO categoryDto) {
		
	if(categoryRepository.existsByCategory(categoryDto.getCategory())) {

			throw ProductServiceException
					.builder()
					.msg("Category already exist")
					.errCode("CATEGORY_ALREADY_EXIST")
					.httpStatus(HttpStatus.CONFLICT).build();
		}

		Category category = CategoryMapper.convertToCategory(categoryDto);

		Category savedCategory = categoryRepository.save(category);
		
		

		return CategoryMapper.convertToCategoryDTO(savedCategory);
	}

	@Override
	public CategoryDTO updateCategory(Integer categoryId, CategoryDTO categoryDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryDTO> getAllCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryDTO getCategoryById(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryDTO deleteCategoryById(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

}
