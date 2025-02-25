package com.moviemax.exception;

public class InvalidUserNameException  extends MovieMaxBootException{
	private static final long serialVersionUID =1L;
	public InvalidUserNameException(String message) {
		super(message);
	}

}
