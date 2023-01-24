package com.example.accountmanagementappbackend.exceptions;



public class HttpMsgNotReadableException extends RuntimeException {

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

	public HttpMsgNotReadableException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		ErrorMessage = errorMessage;
	}

	public HttpMsgNotReadableException() {
		super();
	}
	
}
