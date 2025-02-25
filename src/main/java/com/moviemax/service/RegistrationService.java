package com.moviemax.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviemax.exception.InvalidCityException;
import com.moviemax.exception.InvalidEmailException;
import com.moviemax.exception.InvalidPhoneException;
import com.moviemax.exception.InvalidUserNameException;
import com.moviemax.exception.MovieMaxBootException;
import com.moviemax.model.User;
import com.moviemax.repository.UserRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private UserRepository userRepository;
	
	public String registerUser(User user) throws
	MovieMaxBootException{
		String registerMsg=null;
		validateUser(user);
		registerMsg=userRepository.registerUser();
		return registerMsg;
	}
	
	private void validateUser(User user) throws MovieMaxBootException{
		if(!isValidUserName(user.getName()))
			throw new InvalidUserNameException("RegistrationService.INVALID_USERNAME");
		if(!isValidEmail(user.getEmail()))
			throw new InvalidEmailException("RegistrationService.INVALID_EMAIL");
		if(!isValidPhone(user.getPhone()))
			throw new InvalidPhoneException("RegistrationService.INVALID_PHONENUMBER");
		if(!isValidCity(user.getCity()))
			throw new InvalidCityException("RegistrationService.INVALID_CITY");
		
	}
	private Boolean isValidCity(String city) {
		// TODO Auto-generated method stub
		Boolean b1=false;
		String regexcity = "^[a-zA-Z]{3,15}";
		Pattern pattern1=Pattern.compile(regexcity);
		Matcher matcher1=pattern1.matcher(city);
		if(matcher1.matches())
			b1=true;
		return b1;
	}
	private Boolean isValidPhone(String phone) {
		// TODO Auto-generated method stub
		Boolean b1=false;
		String regexphone="[0-9]{10}";
		Pattern pattern1=Pattern.compile(regexphone);
		Matcher matcher1=pattern1.matcher(phone);
		if(matcher1.matches())
			b1=true;
		return b1;
	}
	private boolean isValidEmail(String email) {
		Boolean b1=false;
		String regemail="[a-zA-Z0-9+_.-]+@(.+)$";
		Pattern pattern1=Pattern.compile(regemail);
		Matcher matcher1=pattern1.matcher(email);
		if(matcher1.matches())
			b1=true;
		return b1;
	}
	private Boolean isValidUserName(String name) {
		// TODO Auto-generated method stub
		Boolean b1=false;
		String regexName="^[a-zA-Z]{3,25}+$";
		Pattern pattern1=Pattern.compile(regexName);
		Matcher matcher1=pattern1.matcher(name);
		if(matcher1.matches())
			b1=true;
		return b1;
	}
	
	
	

}
