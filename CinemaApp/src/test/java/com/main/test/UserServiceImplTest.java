package com.main.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.main.dao.UserDao;
import com.main.dao.UserDaoJDBCImpl;
import com.main.pojo.User;
import com.main.service.UserService;
import com.main.service.UserServiceImpl;

class UserServiceImplTest {

	private static User user;
	
	private static UserDao userdao;
	
	private static UserService service;
	
	@Before
	void setUp() throws Exception {
		user = new User("username", "password");
		userdao = new UserDaoJDBCImpl();
		service = new UserServiceImpl(userdao);
	}

	@After
	void tearDown() throws Exception {
		user = null;
		userdao = null;
		service = null;
	}

	@Test
	void testExistingUser() {
		assertTrue(service.existingUser(user));
	}

	@Test
	void testVerifyUser() {
		assertEquals(service.verifyUser(user), user);
	}

	@Test
	void testRegisterUser() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateUser() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveUser() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCurrentUser() {
		fail("Not yet implemented");
	}

}
