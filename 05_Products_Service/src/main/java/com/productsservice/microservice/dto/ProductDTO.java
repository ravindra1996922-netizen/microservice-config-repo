package com.productsservice.microservice.dto;

import lombok.Data;

@Data
public class ProductDTO {
	
	private Integer productId;
	private String name;
	private String desc;
	private Double price;
	private Integer stock;
	private String image;
	private Integer discount;
	private Double priceBeforeDiscount;

	private Integer categoryId;

}
