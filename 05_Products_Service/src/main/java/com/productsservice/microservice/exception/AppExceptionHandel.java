package com.productsservice.microservice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandel {

	@ExceptionHandler(value = ProductServiceException.class)
	public ResponseEntity<ErrorResponse> handelProductServiceException(
			ProductServiceException productServiceException) {
		
		ErrorResponse errorResponse= new ErrorResponse();
		errorResponse.setErrCode(productServiceException.getErrCode());
		errorResponse.setErrMsg(productServiceException.getMessage());
		
		return new ResponseEntity<>(errorResponse,productServiceException.httpStatus);

	}

}
