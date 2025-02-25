package com.moviemax.exception;

public class InvalidCityException extends MovieMaxBootException{
	private static final long serialVersionUID =1L;
	public InvalidCityException(String message) {
		super(message);
	}

}
