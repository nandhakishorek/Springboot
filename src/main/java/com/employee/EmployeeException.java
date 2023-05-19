package com.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeException {
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Object> idNotFound() {
		return new ResponseEntity<>("No Employee in this id", HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NameNotFoundException.class)
	public ResponseEntity<Object> nameNotFound() {
		return new ResponseEntity<>("No Employee in this name", HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(AgeLimitException.class)
	public ResponseEntity<Object> AgeLimitFound() {
		return new ResponseEntity<>("Below 18 not allowed", HttpStatus.NOT_FOUND);
	}
	
}