package com.student.details.exception;

import org.springframework.http.HttpStatus;

public class NoDataFound extends ApiException {
	public NoDataFound(String message) {
		super(HttpStatus.NOT_FOUND, message );
	}

	public NoDataFound(int statusCode, String message) {
		super(HttpStatus.NOT_FOUND, statusCode, message ); 
}
}
