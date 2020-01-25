package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import com.revature.models.UserDTO;
import com.revature.repositories.UserDAOImpl;
import com.revature.services.UserService;

//@RestController
//@CrossOrigin(origins="*", allowCredentials="true", allowedHeaders="*", methods= {RequestMethod.POST, RequestMethod.GET})
@CrossOrigin
@Controller
public class UserController {

	
	private static final Logger logger = LogManager.getLogger(UserController.class);
	@Autowired
	 private UserService us;

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
	@PostMapping(value = "/login")

	public ResponseEntity<UserDTO> findByEmail(@RequestBody LoginDTO login) {

	//@ResponseBody
	//public ResponseEntity<User> findByEmail(@RequestBody LoginDTO login) {

		System.out.println("inside of UserController login method");
		String email = login.getEmail();
		String pass = login.getPassword();
		if (us.verifyUser(email, pass)) {
			User user = us.findByEmail(email);
			UserDTO dto = new UserDTO(user);
			logger.info("Successful User login with email: " + user.getEmail());	

			return ResponseEntity.ok().body(dto);
		} else {
			UserDTO user = null;
			logger.warn("Attempted and failed login with User email: " + user.getEmail());

		//	return ResponseEntity.ok(user);
	//	} else {
		//	User user = null;
		//	logger.warn("Attempted and failed login with User email: " + email);

			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(user);
		}
	}
	
	

//	@PostMapping(value = "/user")
	//public ResponseEntity<UserDTO> saveOrAddUser(@RequestBody UserDTO userdto) {

	@PostMapping(value = "/user/{email}")
	@ResponseBody
	public ResponseEntity<User> saveOrAddUser(@RequestBody UserDTO userdto) {

		System.out.println("inside of saveOrAddUser method in UserController");
//		String f_name = userdto.getF_name();
//		String l_name = userdto.getL_name();
//		String email = userdto.getEmail();
//		String password = userdto.getPassword();
//		String user_status = userdto.getUser_status();
//		String current_state = userdto.getCurrent_state();
		User user = new User(userdto);
		if(us.upsert(user) != null) {
			UserDTO dto = new UserDTO(user);
			System.out.println("us.upsert(user) in user controller is not null");
			return ResponseEntity.status(HttpStatus.CREATED).body(dto);
		} else {
			UserDTO dto = null;
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(dto);
		}
	}

//	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/state/{st}")
	@ResponseBody
	public ResponseEntity<List<User>> findByState(@PathVariable("st") String st) {
		System.out.println("Inside of findByState method of UserController");
		if (us.findByState(st) != null) {
			System.out.println("Inside of findByState method if conditional of UserController");
			List<User> list = us.findByState(st);
			
			System.out.println("used the userService to create a list UserController");
			return ResponseEntity.ok().body(list);
		} else {
			List<User> list = null;
			System.out.println("list is null apparently of UserController");

			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(list);
		}
	}

//	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ResponseBody
	public List<User> findAll() {
		return us.findAll();
		 
		
	}

}
