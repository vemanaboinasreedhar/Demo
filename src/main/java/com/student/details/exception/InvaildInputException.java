package com.student.details.exception;

import org.springframework.http.HttpStatus;

public class InvaildInputException extends ApiException {
public InvaildInputException(String message) {
	super(HttpStatus.BAD_REQUEST, message );
}

public InvaildInputException(int statusCode, String message) {
	super(HttpStatus.BAD_REQUEST, statusCode, message );
}

}
