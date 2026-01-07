package com.learnwithranjan.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnwithranjan.restservices.entities.User;
import com.learnwithranjan.restservices.exceptions.UserExistsException;
import com.learnwithranjan.restservices.exceptions.UserNotFound;
import com.learnwithranjan.restservices.repositories.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository userRepository;
	
	//getAllUsers
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	//without handle exception
	/*public User createUsers(User user) {
		return userRepository.save(user);
	}*/
	//handle exception
	public User createUsers(User user) throws UserExistsException {
		User existUser = userRepository.findByUsername(user.getUsername());
		if(existUser != null) {
			throw new UserExistsException("User alredy exists in repository");
		}
		return userRepository.save(user);
	}
	
	
	// without handle exception 
	/*public Optional<User> getUserByID(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user;
	}*/
	
	//handle exception
	public Optional<User> getUserByID(Long id) throws UserNotFound {
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFound("User Not found in repository");
		}
		return user;
	}
	
	//without handle exception
	/*public User updateUserByID(Long id,User user) {
		user.setId(id);
		return userRepository.save(user);
	}*/
	
	//handle exception
	public User updateUserByID(Long id,User user) throws UserNotFound {
		Optional<User> optionalUser = userRepository.findById(id);
		if(!optionalUser.isPresent()) {
			throw new UserNotFound("User Not found in repository, provide correct repository");
		}
		return userRepository.save(user);
	}
	
	//without handle exception
	/*public void deleteUserByID(Long id) {
		if(userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
		}
	}*/
	
	//handle exception
	public void deleteUserByID(Long id) throws UserNotFound {
		Optional<User> optionalUser = userRepository.findById(id);
		if(!optionalUser.isPresent()) {
			throw new UserNotFound("User Not found in repository, provide correct user repository");
		}
		if(userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
		}
	}
	
	public User getUserByUserName(String userName) {
		return userRepository.findByUsername(userName);
	}

}
