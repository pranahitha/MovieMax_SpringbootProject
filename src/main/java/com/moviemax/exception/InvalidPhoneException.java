package com.moviemax.exception;

public class InvalidPhoneException extends MovieMaxBootException{
	private static final long serialVersionUID =1L;
	public InvalidPhoneException(String message) {
		super(message);
	}

}
