package com.productsservice.microservice.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.productsservice.microservice.dto.ProductDTO;

public interface  ProductService {
	
	public ProductDTO addProduct (ProductDTO productDto, MultipartFile file);

	public ProductDTO updateProduct (Integer productId, ProductDTO productDto, MultipartFile file) ;

	public List<ProductDTO> getAllProducts ();

	public ProductDTO getProductById(Integer productId);

	public ProductDTO deleteProductById(Integer productId);
	
	public boolean updateStock (Integer productId, Integer quantity) ;

}
