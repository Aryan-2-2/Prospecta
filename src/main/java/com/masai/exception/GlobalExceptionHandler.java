package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	ResponseEntity<MyErrorDetails> noHandlerFound(NoHandlerFoundException nhf, WebRequest wr){
		MyErrorDetails err = new MyErrorDetails();
		err.setDateTime(LocalDateTime.now());
		err.setMessage(nhf.getMessage());
		err.setDescription(wr.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	ResponseEntity<MyErrorDetails> exceptionHandler(Exception ie, WebRequest wr){
		MyErrorDetails err = new MyErrorDetails();
		err.setDateTime(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDescription(wr.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
}
