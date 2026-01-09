package com.learnwithranjan.restservices.contollers;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnwithranjan.restservices.dtos.UserMmDto;
import com.learnwithranjan.restservices.entities.User;
import com.learnwithranjan.restservices.exceptions.UserNotFound;
import com.learnwithranjan.restservices.services.UserServices;

import jakarta.validation.constraints.Min;

@RestController
@RequestMapping(value="/modelmapper/users")
public class UserModelMapperController {

	@Autowired
	private UserServices userServices;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/{id}")
	public UserMmDto getUserById(@PathVariable("id") @Min(1) Long id) throws UserNotFound{
		Optional<User> userOptional = userServices.getUserByID(id);
		if(!userOptional.isPresent()) {
			throw new UserNotFound("UserNotFound");
		}
		User user = userOptional.get();
		
		UserMmDto userMmDto = modelMapper.map(user, UserMmDto.class);
		return userMmDto;
	}
}
