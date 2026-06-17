package com.authservice.microservice.responce;

import lombok.Data;

@Data
public class ApiResponse<T> {
	
	private String message;
	private Integer status;
	private T data;
	

}
