package com.learnwithranjan.restservices.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	//@RequestMapping(method = RequestMethod.GET,path="/hello")
	@GetMapping("/helloo")
	public String helloWorld(){
		return "helloo world";
	}
	
	@GetMapping("/hello-beans")
	public UserDetails getUserDaeils() {
		return new UserDetails("litu", "jena", "bangalore");
	}

}
