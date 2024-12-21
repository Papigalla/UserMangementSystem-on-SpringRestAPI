package com.example.ums.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.ums.exception.UserNotFoundByIdException;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleUserNotById(UserNotFoundByIdException ex) {
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),ex.getMessage(),"User Not found for the given Id"));
		
//		ErrorStructure error = new ErrorStructure();
////		error.setStatus(404);
//		error.setStatus(HttpStatus.NOT_FOUND.value());//if the status is int then invoke .value()  and if it is string invoke .name()  
//		error.setMessage(ex.getMessage());
//		error.setRootCause("User Not found for the given Id");
//		return error;
	}
}
