package com.suchiit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class StudentNotFoundException extends RuntimeException {
	
	
	public StudentNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}

}
