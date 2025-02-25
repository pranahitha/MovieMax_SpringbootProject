package com.moviemax.repository;

import org.springframework.stereotype.Component;

@Component
public class UserRepository {
	private String message = "UserRepository.REGISTRATION_SUCCESS";
	public String registerUser() {
		return message;
	}
	

}
