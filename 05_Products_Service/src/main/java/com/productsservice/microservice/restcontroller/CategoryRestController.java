package com.productsservice.microservice.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productsservice.microservice.dto.CategoryDTO;
import com.productsservice.microservice.response.ApiResponse;
import com.productsservice.microservice.service.CategoryService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CategoryRestController {
	
	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/addcategory")
	public ResponseEntity<ApiResponse<CategoryDTO>> addCategory(@RequestBody CategoryDTO categoryDTO){
		
		log.info("add category handel method");
		CategoryDTO categoryDto = categoryService.addCategory(categoryDTO);
		ApiResponse<CategoryDTO> response=new ApiResponse<>();
		response.setData(categoryDto);
		response.setMessage("category added");
		response.setStatusCode(201);
		
		return new ResponseEntity<ApiResponse<CategoryDTO>>(response,HttpStatus.CREATED);
		
	} 

}
