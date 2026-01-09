package com.learnwithranjan.restservices.contollers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;
import com.learnwithranjan.restservices.entities.User;
import com.learnwithranjan.restservices.entities.Views;
import com.learnwithranjan.restservices.exceptions.UserNotFound;
import com.learnwithranjan.restservices.services.UserServices;

import jakarta.validation.constraints.Min;

@RestController
@Validated
@RequestMapping(value="/users")
public class UserJsonViewController {

	@Autowired
	private UserServices userServices;
	
	@JsonView(Views.External.class)
	@GetMapping("/external/{id}")
	public Optional<User> getUserByIdExternal(@PathVariable("id") @Min(1) Long id) throws UserNotFound{
		try {
			return userServices.getUserByID(id);
		} catch (UserNotFound e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		
	}
	
	@JsonView(Views.Internal.class)
	@GetMapping("/internal/{id}")
	public Optional<User> getUserByIdInternal(@PathVariable("id") @Min(1) Long id) throws UserNotFound{
		try {
			return userServices.getUserByID(id);
		} catch (UserNotFound e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		
	}
}
