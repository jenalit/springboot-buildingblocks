package com.learnwithranjan.restservices.contollers;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnwithranjan.restservices.dtos.UserDtoV1;
import com.learnwithranjan.restservices.dtos.UserDtoV2;
import com.learnwithranjan.restservices.dtos.UserMmDto;
import com.learnwithranjan.restservices.entities.User;
import com.learnwithranjan.restservices.exceptions.UserNotFound;
import com.learnwithranjan.restservices.services.UserServices;

import jakarta.validation.constraints.Min;

@RestController
@RequestMapping(value="/versioning/uri/users")
public class UserUriVersioningController {

	@Autowired
	private UserServices userServices;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping({"/v1.0/{id}","/v1.1/{id}"})
	public UserDtoV1 getUserByIdv1(@PathVariable("id")Long id) throws UserNotFound{
		Optional<User> userOptional = userServices.getUserByID(id);
		if(!userOptional.isPresent()) {
			throw new UserNotFound("UserNotFound");
		}
		User user = userOptional.get();
		
		UserDtoV1 dt01 = modelMapper.map(user, UserDtoV1.class);
		return dt01;
	}
	@GetMapping("/v2.0/{id}")
	public UserDtoV2 getUserByIdv2(@PathVariable("id")Long id) throws UserNotFound{
		Optional<User> userOptional = userServices.getUserByID(id);
		if(!userOptional.isPresent()) {
			throw new UserNotFound("UserNotFound");
		}
		User user = userOptional.get();
		
		UserDtoV2 dt02 = modelMapper.map(user, UserDtoV2.class);
		return dt02;
	}
}
