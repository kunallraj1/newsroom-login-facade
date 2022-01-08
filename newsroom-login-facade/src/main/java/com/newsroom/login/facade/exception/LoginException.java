package com.newsroom.login.facade.exception;

import com.newsroom.login.facade.enums.ErrorCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginException extends Exception {

	private static final long serialVersionUID = 1L;
	private ErrorCode errorCode;
	private String errMsg;
	
	public LoginException(ErrorCode errorCode) {
		this.errorCode=errorCode;
		this.errMsg="Something went wrong, Pls try again later";
	}
	
}
