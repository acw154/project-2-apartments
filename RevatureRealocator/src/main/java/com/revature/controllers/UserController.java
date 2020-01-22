package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.LoginDTO;
import com.revature.models.User;
import com.revature.services.UserService;

//@RestController
@Controller
public class UserController {

	@Autowired
	UserService us;

//	@RequestMapping(value = "/home", method = RequestMethod.GET)
//	public String home() {
//		return "home";
//	}
//	
//	@GetMapping("/home2")
//	public ResponseEntity<String> helloWorld() {
//		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT)
//				.body("Hello World! This is my first Spring Boot Application!");
//	}

//	@CrossOrigin(origins = "http://localhost:4200")
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/login")
	@ResponseBody
	public ResponseEntity<User> findByEmail(@RequestBody LoginDTO login) {
		String email = login.getEmail();
		String pass = login.getPassword();
		if (us.verifyUser(email, pass)) {
			User user = us.findByEmail(email);
			return ResponseEntity.ok().body(user);
		} else {
			User user = null;
			// User user = new User();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(user);
		}
	}

//	@CrossOrigin(origins = "http://localhost:4200")
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/state/{st}")
	@ResponseBody
	public ResponseEntity<List<User>> findByState(@PathVariable("st") String st) {
		System.out.println("Inside of findByState method of UserController");
		if (us.findByState(st) != null) {
			List<User> list = us.findByState(st);
			return ResponseEntity.ok().body(list);
		} else {
			List<User> list = null;

			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(list);
		}
	}

//	@CrossOrigin(origins = "http://localhost:4200")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ResponseBody
	public List<User> findAll() {
		return us.findAll();
	}

}
