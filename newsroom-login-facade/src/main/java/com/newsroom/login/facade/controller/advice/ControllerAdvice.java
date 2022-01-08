package com.newsroom.login.facade.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.newsroom.login.facade.enums.ErrorCode;
import com.newsroom.login.facade.exception.LoginException;
import com.newsroom.login.facade.model.Error;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<com.newsroom.login.facade.model.Error> handleLoginException(LoginException exception)
	{
		
		Error error=Error.builder().errorCode(exception.getErrorCode()).error(exception.getErrMsg()).build();
		
		return new ResponseEntity<Error>(error, HttpStatus.ACCEPTED);
	}
	
}
