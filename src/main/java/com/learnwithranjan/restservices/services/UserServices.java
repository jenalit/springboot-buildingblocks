package com.learnwithranjan.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnwithranjan.restservices.entities.User;
import com.learnwithranjan.restservices.repositories.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository userRepository;
	
	//getAllUsers
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	public User createUsers(User user) {
		return userRepository.save(user);
	}
	
	
	public Optional<User> getUserByID(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user;
	}
	
	
	public User updateUserByID(Long id,User user) {
		user.setId(id);
		return userRepository.save(user);
	}
	
	
	public void deleteUserByID(Long id) {
		if(userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
		}
	}
	
	public User getUserByUserName(String userName) {
		return userRepository.getUserByUsername(userName);
	}

}
