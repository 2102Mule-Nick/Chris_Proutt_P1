package com.main.dao;

import com.main.pojo.User;

public interface UserDao {
	
	public void createUser(User user);
	
	public void deleteUser(User user);
	
	public User getUserByName(String username);
	
	public void updatePassword(User user, String password);
}
