package com.main.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.main.dao.mapper.UserRowMapper;
import com.main.pojo.User;

@Repository
public class UserDaoJDBCImpl implements UserDao {

	@Autowired
	Logger log;
	
	private JdbcTemplate template;
	
	private UserRowMapper mapper;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@Autowired
	public void setMapper(UserRowMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public void createUser(User user) {
		
		String sql = "insert into users (first_name, last_name, email, username, pass_word, account_type) values (?, ?, ?, ?, ?, ?)";

		template.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getUsername(), user.getPassword(), user.getType());
	}

	@Override
	public void deleteUser(User user) {
		String sql = "delete from users where username = ?";

		template.update(sql, user.getUsername());

	}

	@Override
	public User getUserByName(String username) {
		
		String sql = "select * from users where username = ?";
		
		List<User> userList = template.query(sql, mapper, username);
		
		return userList.get(0);
	}

	@Override
	public void updatePassword(User user, String password) {
		String sql = "update users set pass_word = ? where username = ?";

		template.update(sql, password);
	}

	@Override
	public User getUserById(int id) {
		String sql = "select * from users where user_id = ?";
		
		List<User> userList = template.query(sql, mapper, id);
		
		return userList.get(0);
		
	}

}
