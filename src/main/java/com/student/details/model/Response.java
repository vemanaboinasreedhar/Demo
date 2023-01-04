package com.student.details.model;

public class Response {
private Data data;
private Errors error;
public Data getData() {
	return data;
}
public void setData(Data data) {
	this.data = data;
}
public Errors getError() {
	return error;
}
public void setError(Errors error) {
	this.error = error;
}

}
