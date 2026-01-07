package com.learnwithranjan.restservices.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice
public class RestControllerAdviceGlobalHandleException {
	
	@ExceptionHandler(UserNameNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public CustomErrorDetails userNotFoundException(UserNameNotFoundException ex) {
		CustomErrorDetails errorDetails = new CustomErrorDetails(new Date(), "Error from @restControllerAdvice", ex.getMessage());
	    return errorDetails;
	}

}
