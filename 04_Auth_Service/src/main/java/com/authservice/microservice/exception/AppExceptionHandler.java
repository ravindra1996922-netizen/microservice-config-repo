package com.authservice.microservice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(AuthServiceException.class)
	public ResponseEntity<ExceptionResponse> handelAuthServiceExp(
			AuthServiceException authServiceException) {

		ExceptionResponse expRes =
				ExceptionResponse.builder()
				.errCode(authServiceException.getErrcode())
				.errMsg(authServiceException.getMessage())
				.build();

		return new ResponseEntity<>(
				expRes,
				authServiceException.getHttpStatus());
	}
}