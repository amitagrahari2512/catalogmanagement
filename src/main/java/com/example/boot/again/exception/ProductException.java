package com.example.boot.again.exception;

public class ProductException extends RuntimeException {

	private String errorCode;
	private static final long serialVersionUID = -6371311823240238018L;

	public ProductException(String message) {
		super(message);
	}

	public ProductException(String errorcode, String message) {
		super(message);
		this.errorCode = errorcode;
	}

	public ProductException(RuntimeException exception) {
		super(exception);
	}
	
	public String getErrorCode() {
		return errorCode;
	}
}
