package com.learnwithranjan.restservices.contollers;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.learnwithranjan.restservices.entities.User;
import com.learnwithranjan.restservices.exceptions.UserNotFound;
import com.learnwithranjan.restservices.services.UserServices;

import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/jacksonfilter/users")
@Validated
public class UserMappingJacksonController {
	@Autowired
	private UserServices userServices;
	
	@GetMapping("/{id}")
	public MappingJacksonValue getUserById(@PathVariable("id") @Min(1) Long id) throws UserNotFound{
		try {
			Optional<User> userOptional = userServices.getUserByID(id);
			User user = userOptional.get();
			MappingJacksonValue mapper = new MappingJacksonValue(user);
			Set<String> fileds = new HashSet<String>();
			fileds.add("username");
			fileds.add("firstname");
			fileds.add("lastname");
			FilterProvider fillters = new SimpleFilterProvider()
					.addFilter("userFilter", SimpleBeanPropertyFilter.filterOutAllExcept(fileds));
			mapper.setFilters(fillters);
			
			return mapper;
		} catch (UserNotFound e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		
	}
	
	@GetMapping("/dynamic/{id}")
	public MappingJacksonValue getUserByIdDynamic(@PathVariable("id") @Min(1) Long id,@RequestParam Set<String> fileds) throws UserNotFound{
		try {
			Optional<User> userOptional = userServices.getUserByID(id);
			User user = userOptional.get();
			MappingJacksonValue mapper = new MappingJacksonValue(user);
			/*Set<String> fileds = new HashSet<String>();
			fileds.add("username");
			fileds.add("firstname");
			fileds.add("lastname");*/
			FilterProvider fillters = new SimpleFilterProvider()
					.addFilter("userFilter", SimpleBeanPropertyFilter.filterOutAllExcept(fileds));
			mapper.setFilters(fillters);
			
			return mapper;
		} catch (UserNotFound e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		
	}
}
