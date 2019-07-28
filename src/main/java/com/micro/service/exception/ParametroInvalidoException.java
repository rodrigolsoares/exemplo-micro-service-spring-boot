package com.micro.service.exception;

public class ParametroInvalidoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ParametroInvalidoException(String msg) {
		super(msg);
	}
	
	public ParametroInvalidoException(String msg, Throwable cause ) {
		super(msg, cause);
	}
	
	

}
