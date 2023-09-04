package com.example.springbootjpa.exception;

public class CustomNotExistException extends RuntimeException {
	private final String message;

	public CustomNotExistException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
