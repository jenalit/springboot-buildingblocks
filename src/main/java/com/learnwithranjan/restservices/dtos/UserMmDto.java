package com.learnwithranjan.restservices.dtos;

import java.util.List;

import com.learnwithranjan.restservices.entities.Order;

public class UserMmDto {
	private String username;
	private String firstname;
	private String lastname;
	private List<Order> orders;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
