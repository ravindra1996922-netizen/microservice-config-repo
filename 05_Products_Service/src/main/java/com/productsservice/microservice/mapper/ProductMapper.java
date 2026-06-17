package com.productsservice.microservice.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.productsservice.microservice.dto.ProductDTO;
import com.productsservice.microservice.entity.Product;

public class ProductMapper {
	
	
	
	static ModelMapper modelMapper =new ModelMapper();
	
	
	public static ProductDTO  convertToProductDTO(Product product) {
		return modelMapper.map(product, ProductDTO.class);

	}
	
	public static Product  convertToProduct(ProductDTO productDto) {
		return modelMapper.map(productDto, Product.class);

	}

}
