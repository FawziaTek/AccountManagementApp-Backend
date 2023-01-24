package com.example.accountmanagementappbackend.exceptions;

import org.springframework.stereotype.Component;

@Component
public class InvalidInput extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	
	private String ErrorMessage;
	
	public String getErrorCode() {
		return errorCode;
	}
	
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public String getErrorMessage() {
		return ErrorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}
	
	public InvalidInput(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.ErrorMessage = errorMessage;
	}
	
	public InvalidInput() {
		super();
	}
	
	public InvalidInput(String errorMessage) {
		super();
		this.ErrorMessage = errorMessage;
	}
	
}
