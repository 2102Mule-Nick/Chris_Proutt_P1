package com.main.service;

import com.main.pojo.User;

public interface UserService {
	
	public boolean existingUser(User user);
	
	public User verifyUser(User user);
	
	public User registerUser(User user);
	
	public User updateUser(User user);
	
	public boolean removeUser(User user);
	
	public User getCurrentUser();
}
