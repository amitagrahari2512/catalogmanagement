package com.example.boot.again.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.boot.again.exception.CatalogException;
import com.example.boot.again.exception.ProductException;
import com.example.boot.again.exception.ResponseMsg;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class RestfulControllerAdvice {
	
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ProductException.class)
	public ResponseMsg handleProductException(ProductException ex) {
		log.debug("Returning HTTP 400 Bad Request", ex);
		ResponseMsg responseMsg = new ResponseMsg(ex.getMessage());
		return responseMsg;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(CatalogException.class)
	public ResponseMsg handleCatalogException(CatalogException ex) {
		log.debug("Returning HTTP 400 Bad Request", ex);
		ResponseMsg responseMsg = new ResponseMsg(ex.getMessage());
		return responseMsg;
	}
}
