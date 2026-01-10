package com.learnwithranjan.restservices.dtos;

public class UserMsDto {
	private String username;
	private String firstname;
	private String lastname;
	private String emailAddress;
	private String roleAssigned;

	public UserMsDto() {
	}


	public UserMsDto(String username, String firstname, String lastname, String emailAddress, String roleAssigned) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailAddress = emailAddress;
		this.roleAssigned = roleAssigned;
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public String getRoleAssigned() {
		return roleAssigned;
	}


	public void setRoleAssigned(String roleAssigned) {
		this.roleAssigned = roleAssigned;
	}
	

}
