package com.learnwithranjan.restservices.contollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.learnwithranjan.restservices.entities.User;
import com.learnwithranjan.restservices.exceptions.UserExistsException;
import com.learnwithranjan.restservices.exceptions.UserNameNotFoundException;
import com.learnwithranjan.restservices.exceptions.UserNotFound;
import com.learnwithranjan.restservices.services.UserServices;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
@Validated
@RequestMapping(value="/users")
public class UserController {
	
	@Autowired
	private UserServices userServices;
	
	@GetMapping
	public List<User> getAllUsers(){
		return userServices.getAllUser();
	}
	
	/*@PostMapping("/users")
	public User createUser(@RequestBody User user) throws UserExistsException {
		try {
			return userServices.createUsers(user);
		} catch (UserExistsException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}	
	}*/
	
	@PostMapping
	public ResponseEntity<Void> createUser(@Valid @RequestBody User user, UriComponentsBuilder builder) throws UserExistsException {
		try {
			userServices.createUsers(user);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(builder.path("/users/{id}").buildAndExpand(user.getId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		} catch (UserExistsException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}	
	}
	
	@GetMapping("/{id}")
	public Optional<User> getUserById(@PathVariable("id") @Min(1) Long id) throws UserNotFound{
		try {
			return userServices.getUserByID(id);
		} catch (UserNotFound e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		
	}
	
	@PutMapping("/{id}")
	public User updateUserByID(@PathVariable("id")Long id,@RequestBody User user) throws UserNotFound {
		try {
			return userServices.updateUserByID(id, user);
		} catch (UserNotFound e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable("id")Long id) throws UserNotFound{
		try {
			userServices.deleteUserByID(id);
		} catch (UserNotFound e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@GetMapping("/byusername/{username}")
	public User getUserByUserName(@PathVariable("username")String username) throws UserNameNotFoundException{
		User user = userServices.getUserByUserName(username);
		if(user == null) {
			throw new UserNameNotFoundException("User not exist");
		}
		return userServices.getUserByUserName(username);
	}

}
