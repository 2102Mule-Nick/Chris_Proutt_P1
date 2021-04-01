package com.main.service;

//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.main.dao.UserDao;
import com.main.pojo.User;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	//Logger log;
	
	private UserDao userdao;
	
	public UserServiceImpl(UserDao userdao) {
		this.userdao = userdao;
	}

	public UserDao getUserdao() {
		return userdao;
	}

	@Autowired
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	@Override
	public boolean existingUser(User user) {
		//log.trace("Existing User called");
		
		try {
			if(userdao.getUserByName(user.getUsername()) != null) {
				//log.info("User exists");
				return true;
			}
		} catch (Exception e) {
			//log.error("User Not Found.");
			System.out.println("User Not Found");
		}
		
		return false;
	}

	@Override
	public User verifyUser(User user) {
		
		User existingUser = userdao.getUserByName(user.getUsername());
		
		if(existingUser.equals(user)) {
			return existingUser;
		}
		return user;
	}

	@Override
	public User registerUser(User user) {
		return null;
	}

	@Override
	public User updateUser(User user, String password) {
		return null;
	}

	@Override
	public boolean removeUser(User user) {
		return false;
	}

	@Override
	public User getCurrentUser() {
		return null;
	}

	@Override
	public User getUserById(User user) {
		User newUser = userdao.getUserById(user.getUser_id());
		return newUser;
	}

}
