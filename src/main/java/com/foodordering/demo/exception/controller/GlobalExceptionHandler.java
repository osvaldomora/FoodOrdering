package com.foodordering.demo.exception.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.foodordering.demo.constants.Constants;
import com.foodordering.demo.exception.ErrorResponse;
import com.foodordering.demo.exception.OrderDetailNotFoundException;
import com.foodordering.demo.exception.UserNotFoundException;
import com.foodordering.demo.exception.ValidationErrorResponse;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(UserNotFoundException ex) {

		System.out.println("ErrorResponse:" + ex.getMessage());
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), Constants.USER_NOT_FOUND);
		return new ResponseEntity<>(errorResponse, HttpStatus.OK);

	}
	
	@ExceptionHandler(OrderDetailNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleExceptionOrderDetail(OrderDetailNotFoundException ex) {

		System.out.println("ErrorResponse:" + ex.getMessage());
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), Constants.USER_NOT_FOUND);
		return new ResponseEntity<>(errorResponse, HttpStatus.OK);

	} 
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationErrorResponse> handleExceptionValid(MethodArgumentNotValidException ex) {

		ValidationErrorResponse errorResponse = new ValidationErrorResponse("invalid arguments parameters", Constants.INVALID_ARGS);
		ex.getBindingResult().getFieldErrors().stream().forEach(error->{
			errorResponse.getInvalidArguments().put(error.getField(), error.getDefaultMessage());
			
		});
		
		errorResponse.setDate(new Date());
		return new ResponseEntity<ValidationErrorResponse>(errorResponse, HttpStatus.OK);

	}
	

}
