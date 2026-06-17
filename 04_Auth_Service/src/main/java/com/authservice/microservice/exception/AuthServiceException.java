package com.authservice.microservice.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class AuthServiceException extends RuntimeException {

	String errcode;
	HttpStatus httpStatus;

	public AuthServiceException() {
		super();
	}

	public AuthServiceException(String msg, String errcode,HttpStatus httpStatus) {
		super(msg);
		this.errcode = errcode;
		this.httpStatus=httpStatus;
	}

}
