package com.student.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	
	@ExceptionHandler(value=AgeNotEligibleException.class)	
	public ResponseEntity<Object>  ageNotEligibleExceptionHandle(AgeNotEligibleException age){		
		return new ResponseEntity<Object>(age.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
