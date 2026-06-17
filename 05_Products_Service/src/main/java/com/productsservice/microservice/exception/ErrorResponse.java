package com.productsservice.microservice.exception;

import lombok.Data;

@Data
public class ErrorResponse {
	
	String errMsg;
	String errCode;

}
