package com.learnwithranjan.restservices.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

//@Table(name="person", schema="usermanagment")
@Entity
@Table(name="person")
//@JsonIgnoreProperties({"firstname","lastname"}) --static filtering
//@JsonFilter(value="userFilter")-- dynamic filtering
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty(message = "Username Should not be Empty")
	@Column(name="USERNAME",length=50,nullable=false,unique=true)
	@JsonView(Views.External.class)
	private String username;
	
	@Size(min=2, message = "First Name should be atlease 2 charcters")
	@Column(name="FIRST_NAME",length=50,nullable=false)
	@JsonView(Views.External.class)
	private String firstname;
	
	@Column(name="LAST_NAME",length=50,nullable=false)
	@JsonView(Views.External.class)
	private String lastname;
	
	@Column(name="EMAIL",length=50,nullable=false)
	@JsonView(Views.Internal.class)
	private String email;
	
	@Column(name="ROLE",length=50,nullable=false)
	@JsonView(Views.Internal.class)
	private String role;
	
	//@JsonIgnore
	@Column(name="SSN",length=50,nullable=false,unique=true)
	@JsonView(Views.Internal.class)
	private String ssn;

	@OneToMany(mappedBy = "user")
	@JsonView(Views.Internal.class)
	private List<Order> orders;
	public User() {
	}
	
	@Column(name="ADDRESS")
	private String address;

	public User(Long id, @NotEmpty(message = "Username Should not be Empty") String username,
			@Size(min = 2, message = "First Name should be atlease 2 charcters") String firstname, String lastname,
			String email, String role, String ssn, List<Order> orders, String address) {
		super();
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
		this.orders = orders;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", role=" + role + ", ssn=" + ssn + ", orders=" + orders + ", address=" + address
				+ "]";
	}
	

}
