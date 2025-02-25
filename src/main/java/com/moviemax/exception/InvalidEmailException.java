package com.moviemax.exception;

public class InvalidEmailException extends MovieMaxBootException{
	private static final long serialVersionUID =1L;
	public InvalidEmailException(String message) {
		super(message);
	}

}
