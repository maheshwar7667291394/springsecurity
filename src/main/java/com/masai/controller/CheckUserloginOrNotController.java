package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.UserException;
import com.masai.mocdel.CurrentUserSesson;
import com.masai.mocdel.LoginDao;
import com.masai.service.CurrentUserSessonService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class CheckUserloginOrNotController {
	
	@Autowired
	public CurrentUserSessonService cuservice;
	
	@PostMapping("/userlogin")
	public ResponseEntity<CurrentUserSesson> Login(@RequestBody LoginDao cuser) throws UserException{
		
		  CurrentUserSesson cuserlogin=cuservice.LoginUser(cuser);
		  
		  return new ResponseEntity<>(cuserlogin,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/userlogout/{key}")
	public ResponseEntity<String> Logout(@PathVariable String key) throws UserException{
		
		String result=cuservice.logout(key);
		return new ResponseEntity<String>(result,HttpStatus.OK);
		
	}

}
