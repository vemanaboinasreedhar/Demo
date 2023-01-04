
  package com.student.details.exception;
  
  import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import
  org.springframework.web.bind.annotation.ControllerAdvice;
import
  org.springframework.web.bind.annotation.ExceptionHandler;

import com.student.details.model.Errors;
import
  com.student.details.model.Response;
  
  @ControllerAdvice 
  public class Handlers{
  
  @ExceptionHandler(Throwable.class) public
  ResponseEntity<Response>handleException(Throwable t, HttpServletRequest request){
	  ApiException rapie = (ApiException)t;
	  if(t instanceof ApiException) {
	  return ResponseEntity.status(((ApiException)t).getHttpStatus()).body(buildResponse((ApiException)t, request));
	  }else {
		  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(buildResponse(new InternalServerErrorException(t.getMessage()), request));  
	  }
	  
  
  }
  
  public Response buildResponse(ApiException api, HttpServletRequest request) {
	  Response res = new Response();
	  Errors error = new Errors();
  error.setHttpStatusCode(api.getHttpStatus().value());
  error.setStatusCode(api.getStatusCode()); 
  error.setMessage(api.getMessage());
  error.setURI(request.getRequestURI());
  res.setError(error);
  return res;
  
  }
  }
 