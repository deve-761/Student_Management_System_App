package com.masai.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GlobalExceptionHandeller {

	
	@ExceptionHandler(StudentException.class)
	public ResponseEntity<MyErorDetails> studentExceptionHandler(StudentException se, WebRequest req){
		
		
		MyErorDetails err= new MyErorDetails();
			err.setTimeStamp(LocalDateTime.now());
			err.setMessage(se.getMessage());
			err.setHttpStatus(HttpStatus.NOT_FOUND);
			err.setDetails(req.getDescription(false));
				
		return new ResponseEntity<MyErorDetails>(err, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CourseException.class)
	public ResponseEntity<MyErorDetails> courseExceptionHandler(CourseException ce, WebRequest req){
		
		
		MyErorDetails err= new MyErorDetails();
			err.setTimeStamp(LocalDateTime.now());
			err.setMessage(ce.getMessage());
			err.setHttpStatus(HttpStatus.NOT_FOUND);
			err.setDetails(req.getDescription(false));
				
		return new ResponseEntity<MyErorDetails>(err, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErorDetails> userExceptionHandler(UserException ce, WebRequest req){
		
		
		MyErorDetails err= new MyErorDetails();
			err.setTimeStamp(LocalDateTime.now());
			err.setMessage(ce.getMessage());
			err.setHttpStatus(HttpStatus.NOT_FOUND);
			err.setDetails(req.getDescription(false));
				
		return new ResponseEntity<MyErorDetails>(err, HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErorDetails> otherExceptionHandler(Exception se, WebRequest req){
		
		
		MyErorDetails err= new MyErorDetails();
			err.setTimeStamp(LocalDateTime.now());
			err.setMessage(se.getMessage());
			err.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			err.setDetails(req.getDescription(false));
				
		return new ResponseEntity<MyErorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	
}
