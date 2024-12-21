package com.example.ums.exception;

public class BaseException extends RuntimeException{
	private String message;

	public BaseException(String message) {
		super();
		this.message = message;
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
