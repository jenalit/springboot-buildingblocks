package com.learnwithranjan.restservices.exceptions;

import java.util.Date;

public class CustomErrorDetails {
	Date date;
	String message;
	String errorDetails;
	public CustomErrorDetails(Date date2, String message, String errorDetails) {
		super();
		this.date = date2;
		this.message = message;
		this.errorDetails = errorDetails;
	}
	public Date getDate() {
		return date;
	}
	public String getMessage() {
		return message;
	}
	public String getErrorDetails() {
		return errorDetails;
	}
	
	

}
