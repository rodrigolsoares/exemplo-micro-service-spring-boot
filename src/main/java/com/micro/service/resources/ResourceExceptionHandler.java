package com.micro.service.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import com.micro.service.exception.ParametroInvalidoException;
import com.micro.service.vo.Errors;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	Logger LOG = LoggerFactory.getLogger(ResourceExceptionHandler.class);
	
	private String ERRO_INSPERADO = "Ocorreu algum erro inesperado, entre em contato com o suporte";
	
	@ExceptionHandler(ParametroInvalidoException.class)
	public ResponseEntity<?> parametroInvalido(ParametroInvalidoException e, HttpRequestHandlerServlet request){
		
		LOG.info("Tratando exceção para o usuário");
		
		Errors err = new Errors(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> ErroInesperado (Exception e, HttpRequestHandlerServlet request){
		
		LOG.info("Tratando exceção para o usuário, erro inesperado");
		LOG.error(e.getMessage());
		
		Errors err = new Errors(HttpStatus.NOT_FOUND.value(), ERRO_INSPERADO, System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
}
