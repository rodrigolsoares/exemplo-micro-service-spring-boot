package com.micro.service.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import com.micro.service.exception.ParametroInvalidoException;
import com.micro.service.vo.Error;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ParametroInvalidoException.class)
	public ResponseEntity<Error> objectNotFound(ParametroInvalidoException e, HttpRequestHandlerServlet request){
		
		Error err = new Error(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
}
