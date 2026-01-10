package com.learnwithranjan.restservices.contollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnwithranjan.restservices.dtos.UserMsDto;
import com.learnwithranjan.restservices.entities.User;
import com.learnwithranjan.restservices.mappers.UserMapper;
import com.learnwithranjan.restservices.repositories.UserRepository;

@RestController
@RequestMapping("/mapstruct/users")
public class UserMapStructController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	@GetMapping
	public List<UserMsDto> getAllUserDtos(){
		return userMapper.userstoUserDtos(userRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public UserMsDto getuserbyID(@PathVariable Long id) {
		Optional<User> userOptional = userRepository.findById(id);
		User user = userOptional.get();
		return userMapper.userToUserMsDto(user);
		
	}

}
