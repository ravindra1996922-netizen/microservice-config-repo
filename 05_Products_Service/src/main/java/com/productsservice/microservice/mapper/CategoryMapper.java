package com.productsservice.microservice.mapper;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.productsservice.microservice.dto.CategoryDTO;
import com.productsservice.microservice.entity.Category;

public class CategoryMapper {
	
	
	static ModelMapper modelMapper =new ModelMapper();
	
	public static CategoryDTO convertToCategoryDTO(Category category) {
		
		CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
		return categoryDTO;
	} 
	
	
public static Category convertToCategory(CategoryDTO categoryDto) {
		
		 Category category = modelMapper.map(categoryDto, Category.class);
		return category;
	} 

}
