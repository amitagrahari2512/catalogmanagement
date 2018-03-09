package com.example.boot.again.exception;

public class CatalogException extends RuntimeException {

	private String errorCode;
	private static final long serialVersionUID = -6371311823240238018L;

	public CatalogException(String message) {
		super(message);
	}

	public CatalogException(String errorcode, String message) {
		super(message);
		this.errorCode = errorcode;
	}

	public CatalogException(RuntimeException exception) {
		super(exception);
	}
	
	public String getErrorCode() {
		return errorCode;
	}
}
