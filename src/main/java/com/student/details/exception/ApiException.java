package com.student.details.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {

	private HttpStatus httpStatus;
	private int statusCode;

	public ApiException(HttpStatus httpStatus, String message) {
		super(message);
		this.httpStatus = httpStatus;
		
	}
	
	public ApiException(HttpStatus httpStatus,int statusCode, String message) {
		super(message);
		this.httpStatus = httpStatus;
		this.statusCode = statusCode;
	}
	
	public ApiException(HttpStatus httpStatus, String message, Throwable t) {
		super(message);
		this.httpStatus = httpStatus;
		
	}

	public HttpStatus getHttpStatus() {
		// TODO Auto-generated method stub
		return httpStatus;
	}
	
	public int getStatusCode() {
		// TODO Auto-generated method stub
		return statusCode;
	}
}
