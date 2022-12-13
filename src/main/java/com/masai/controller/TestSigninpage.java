package com.masai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestSigninpage {
	
	@GetMapping("/signin")
	public String Sigin() {
		return "login";
	}
	@PostMapping("/register")
	public String Sigi() {
		return "login";
	}

}
