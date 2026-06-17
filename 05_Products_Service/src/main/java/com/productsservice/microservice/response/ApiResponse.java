package com.productsservice.microservice.response;

import lombok.Data;

@Data
public class ApiResponse<T> {

	private Integer statusCode;
	private String message;
	private T data;
}
