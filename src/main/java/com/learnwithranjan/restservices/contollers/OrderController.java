package com.learnwithranjan.restservices.contollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnwithranjan.restservices.entities.Order;
import com.learnwithranjan.restservices.entities.User;
import com.learnwithranjan.restservices.exceptions.OrderNotFoundException;
import com.learnwithranjan.restservices.exceptions.UserNotFound;
import com.learnwithranjan.restservices.repositories.OrderRepository;
import com.learnwithranjan.restservices.repositories.UserRepository;

@RestController
@RequestMapping(value="/users")
public class OrderController {
	
	@Autowired
	private UserRepository userReository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("/{userid}/orders")
	public List<Order> getAllOrders(@PathVariable Long userid) throws UserNotFound {
		Optional<User> user = userReository.findById(userid);
		if(!user.isPresent()) {
			throw new UserNotFound("User Not Found");
		}
		
		return user.get().getOrders();
	}
	
	@PostMapping("/{userid}/orders")
	public Order createOrder(@PathVariable Long userid,@RequestBody Order order ) throws UserNotFound {
		Optional<User> user = userReository.findById(userid);
		if(!user.isPresent()) {
			throw new UserNotFound("User Not Found");
		}
		
		User users = user.get();
		order.setUser(users);
		return orderRepository.save(order);
		
	}
	
	@GetMapping("/{orderId}/order")
	public Order getOrderByOrdeID(@PathVariable Long orderId) throws OrderNotFoundException {
		Optional<Order> order = orderRepository.findById(orderId);
		if(!order.isPresent()) {
			throw new OrderNotFoundException("order not found exception");
		}
		
		return order.get();
	}
}
