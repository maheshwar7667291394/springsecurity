package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.UserException;
import com.masai.mocdel.User;
import com.masai.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class Mucontroller  {
	@Autowired
	public UserService uservice;
	
	
	@PostMapping("/user")
	public ResponseEntity<User> Registeruser(@RequestBody User user) throws UserException{
		
		User ruser=uservice.registerUser(user);
		return new ResponseEntity<>(ruser,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> FindAlluser() throws UserException{
		List<User> listuser=uservice.GetAlluser();
		return new ResponseEntity<List<User>>(listuser,HttpStatus.OK);
		
		
	}

}
