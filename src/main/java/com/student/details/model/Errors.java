package com.student.details.model;

public class Errors {
	private int httpStatusCode;
private int statusCode;
private String message;
private String URI;
public int getHttpStatusCode() {
	return httpStatusCode;
}
public void setHttpStatusCode(int httpStatusCode) {
	this.httpStatusCode = httpStatusCode;
}
public int getStatusCode() {
	return statusCode;
}
public void setStatusCode(int statusCode) {
	this.statusCode = statusCode;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getURI() {
	return URI;
}
public void setURI(String uRI) {
	URI = uRI;
}

}
