package com.kh.spring09home.error;


public class UnauthorizationException extends RuntimeException
{
	private static final long serialVersionUID = 1;
	public UnauthorizationException() {
		super();
	}	
	public UnauthorizationException(String message) {
		super(message);
	}
}