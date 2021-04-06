package com.main.pojo;

import org.springframework.stereotype.Component;

@Component
public class User {

	private int user_id;
	
	private String username;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String type;
	
	private boolean isAdmin;
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean getIsAdmin() {
		return isAdmin;
	}
	
	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

}
