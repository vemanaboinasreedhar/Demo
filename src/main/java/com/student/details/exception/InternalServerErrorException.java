package com.student.details.exception;

import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends ApiException {
	public InternalServerErrorException(String message) {
		super(HttpStatus.INTERNAL_SERVER_ERROR, message );
	}

	public InternalServerErrorException(int statusCode, String message) {
		super(HttpStatus.INTERNAL_SERVER_ERROR, statusCode, message );
	}

}
