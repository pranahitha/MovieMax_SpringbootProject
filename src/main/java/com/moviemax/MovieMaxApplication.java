package com.moviemax;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.moviemax.model.User;
import com.moviemax.service.RegistrationService;

@SpringBootApplication
@PropertySource(value={"classpath:configuration.properties"})
public class MovieMaxApplication implements CommandLineRunner {

	@Autowired
	Environment environment;
	
	@Autowired
	ApplicationContext context;
	
	public static void main(String[] args) {
		SpringApplication.run(MovieMaxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		try
		{
			Map<String,String> movies = new HashMap<String,String>();
			movies.put("SpiderMan", "M1001");
			movies.put("Thor", "M1002");
			movies.put("Logan", "M1003");
			movies.put("Conguring 2", "M1004");
			movies.put("StarWars", "M1005");
			User user =new User();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter name : ");
			String name = sc.next();
			System.out.println("Enter email id : ");
			String email=sc.next();
			System.out.println("Enter phone number :");
			String phone = sc.next();
			System.out.println("Enter your city");
			String city=sc.next();
			System.out.println("Select a movie :");
			for(String i:movies.keySet()) {
				System.out.println(i);
			}
			String movie =sc.next();
			String movieId=null;
			for(String i:movies.keySet()) {
				if(i.contains(movie))
					movieId = movies.get(i);					
			}
			
			user.setCity(city);
			user.setEmail(email);
			user.setName(name);
			user.setPhone(phone);
			RegistrationService service = (RegistrationService)context.getBean("registrationService");
			String registerMessage = service.registerUser(user);
			System.out.println("Hi "+user.getName()+"\n"+
					environment.getProperty(registerMessage) + movieId);
						
		}catch (Exception e) {
			System.out.println(environment.getProperty(e.getMessage()));
		}
	}
	

}
