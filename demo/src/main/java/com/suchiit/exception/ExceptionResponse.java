package com.suchiit.exception;

import java.util.Date;

public class ExceptionResponse {

public ExceptionResponse(String message, String details, Date timestamp) {
	super();
	this.message = message;
	this.details = details;
	this.timestamp = timestamp;
}
String message;
String details;
Date timestamp;
}
