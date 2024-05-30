package com.employee.globalExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.employee.exception.InvalidException;
import com.employee.exception.NoValueException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(InvalidException.class)
	public ResponseEntity<Object> getException(InvalidException e){
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NoValueException.class)
	public ResponseEntity<Object> getNew(NoValueException n){
		return new ResponseEntity<>(n.getMessage(), HttpStatus.ALREADY_REPORTED);
	}
}
