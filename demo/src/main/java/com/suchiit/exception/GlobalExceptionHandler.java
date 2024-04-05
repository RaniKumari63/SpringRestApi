package com.suchiit.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
@ControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(Exception.class)
public 	final ResponseEntity<Object> handleAllException(Exception ex,WebRequest req)
{
	
	ExceptionResponse exRes=new ExceptionResponse(ex.getMessage(),req.getDescription(false),new Date());
	return new ResponseEntity<Object>(exRes,HttpStatus.INTERNAL_SERVER_ERROR);
	
}
	
@ExceptionHandler(RecordNotFoundException.class)
public 	final ResponseEntity<Object> handleResourceNotFoundException(Exception ex,WebRequest req)
{  
	
	ExceptionResponse exRes=new ExceptionResponse(ex.getMessage(),req.getDescription(false),new Date());
	return new ResponseEntity<Object>(exRes,HttpStatus.NOT_FOUND);
	
}
	
}
