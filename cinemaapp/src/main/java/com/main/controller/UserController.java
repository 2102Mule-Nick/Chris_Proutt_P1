package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.pojo.User;
import com.main.service.UserService;

@RestController
public class UserController {

	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
	@PostMapping("/rest/user/create-user")
	@ResponseBody
	public User createUser(@RequestBody User user) {
		userService.registerUser(user);
		return user;
	}
	
	@GetMapping("/rest/user/{id}")
	@ResponseBody
	public User getUserById(@RequestBody User user){
		return userService.getUserById(user);
	}
	
	@PutMapping("/rest/user/change_password")
	@ResponseBody
	public String changeUserPassword(@RequestBody User user, @RequestBody String password) {
		userService.updateUser(user, password);
		return "Password updated";
	}
	
	@DeleteMapping("/rest/user/delete-user")
	@ResponseBody
	public String deletePassword(@RequestBody User user) {
		//userdao.deleteUser(user);
		userService.removeUser(user);
		return "User deleted";
	}
	
}
