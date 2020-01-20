package com.revature.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@GetMapping("/home2")
	public ResponseEntity<String> helloWorld() {
		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT)
				.body("Hello World! This is my first Spring Boot Application!");
	}
}
