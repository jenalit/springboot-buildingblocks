package com.learnwithranjan.restservices.contollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learnwithranjan.restservices.entities.User;
import com.learnwithranjan.restservices.services.UserServices;

@RestController
public class UserController {
	
	@Autowired
	private UserServices userServices;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userServices.getAllUser();
	}
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		return userServices.createUsers(user);
	}
	
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable("id")Long id){
		return userServices.getUserByID(id);
	}
	
	@PutMapping("/users/{id}")
	public User updateUserByID(@PathVariable("id")Long id,@RequestBody User user) {
		return userServices.updateUserByID(id, user);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable("id")Long id) {
		userServices.deleteUserByID(id);
	}
	
	@GetMapping("/users/byusername/{username}")
	public User getUserByUserName(@PathVariable("username")String username) {
		return userServices.getUserByUserName(username);
	}

}
