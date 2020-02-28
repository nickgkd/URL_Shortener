package com.urlShortner.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	   public ResponseEntity<Object> exception(Exception exception) {
	      return new ResponseEntity<>("Please enter Url to shorten", HttpStatus.NOT_FOUND);
	   }
}
