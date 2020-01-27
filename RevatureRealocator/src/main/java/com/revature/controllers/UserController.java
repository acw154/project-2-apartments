package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
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

import com.revature.models.AdaptiveUser;
import com.revature.models.LoginDTO;
import com.revature.models.PreferenceDTO;
import com.revature.models.Property;
import com.revature.models.PropertyDTO;
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

	public ResponseEntity<AdaptiveUser> findByEmail(@RequestBody LoginDTO login) {

	//@ResponseBody
	//public ResponseEntity<User> findByEmail(@RequestBody LoginDTO login) {

		System.out.println("inside of UserController login method");
		String email = login.getEmail();
		String pass = login.getPassword();
		pass = DigestUtils.sha256Hex(pass);
		if (us.verifyUser(email, pass)) {
			User user = us.findByEmail(email);
			List<PropertyDTO> pdtoList = new ArrayList<>();
			for(Property p : user.getSavedProperties()) {
				pdtoList.add(new PropertyDTO(p));
			}
			AdaptiveUser result = new AdaptiveUser(user.getId(), user.getEmail(), user.getPassword(), user.getF_name(), user.getL_name(), new PreferenceDTO(user.getPreference()), pdtoList, user.getCurrent_state(), user.getUserStatus());
			//UserDTO dto = new UserDTO(user);
			logger.info("Successful User login with email: " + user.getEmail());	

			return ResponseEntity.ok().body(result);
		} else {
			AdaptiveUser result = null;
			logger.warn("Attempted and failed login with User email: " + login.getEmail());

		//	return ResponseEntity.ok(user);
	//	} else {
		//	User user = null;
		//	logger.warn("Attempted and failed login with User email: " + email);

			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(result);
		}
	}
	
	@PostMapping(value = "/user/properties")
	public ResponseEntity<List<PropertyDTO>> findPropertiesByEmail(@RequestBody LoginDTO login) {
			String email = login.getEmail();
			String pass = login.getPassword();
			if (us.verifyUser(email, pass)) {
				User user = us.findByEmail(email);
				List<PropertyDTO> dtoList = new ArrayList<>();
				List<Property> userList = user.getSavedProperties();
				for(Property p : userList) {
					PropertyDTO dto = new PropertyDTO(p);
					dtoList.add(dto);
				}
				return ResponseEntity.ok().body(dtoList);
			} else {
				List<PropertyDTO> dtoList = null;
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(dtoList);
			}
		}
	
	

//	@PostMapping(value = "/user")
	//public ResponseEntity<UserDTO> saveOrAddUser(@RequestBody UserDTO userdto) {

	@PostMapping(value = "/user")
	@ResponseBody
	public ResponseEntity<UserDTO> saveOrAddUser(@RequestBody UserDTO userdto) {

		User user = new User(userdto);
		user.setPassword(DigestUtils.sha256Hex(user.getPassword()));
		if(us.upsert(user) != null) {
			UserDTO dto = new UserDTO(user);
			System.out.println("us.upsert(user) in user controller is not null");
			return ResponseEntity.ok().body(dto);
		} else {
			UserDTO dto = null;
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(dto);
		}
	}

//	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/state/{st}")
	@ResponseBody
	public ResponseEntity<List<UserDTO>> findByState(@PathVariable("st") String st) {
		System.out.println("Inside of findByState method of UserController");
		if (us.findByState(st) != null) {
			System.out.println("Inside of findByState method if conditional of UserController");
			List<UserDTO> list = us.findByState(st);
			
			System.out.println("used the userService to create a list UserController");
			return ResponseEntity.ok().body(list);
		} else {
			List<UserDTO> list = null;
			System.out.println("list is null apparently of UserController");

			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(list);
		}
	}



}
