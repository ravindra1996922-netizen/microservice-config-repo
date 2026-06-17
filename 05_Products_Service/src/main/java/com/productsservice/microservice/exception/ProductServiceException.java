package com.productsservice.microservice.exception;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductServiceException extends RuntimeException {

	String errCode;
	String msg;
	HttpStatus httpStatus;

	public ProductServiceException(String msg, String errCode, HttpStatus httpStatus) {
		super(msg);
		this.errCode = errCode;
		this.httpStatus = httpStatus;
	}

}
