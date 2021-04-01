package com.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.main.pojo.User;
import com.main.utilities.ConnectionFactoryPostgres;

@Component
public class UserDaoPostgres implements UserDao {

	@Autowired
	Logger log;
	
	@Override
	public void createUser(User user) {

		log.trace("Create User Called");
		
		Connection conn = ConnectionFactoryPostgres.getConnection();
		
		String sql = "insert into users (first_name, last_name, email, username, pass_word) values (?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement pstmt = conn.prepareCall(sql);
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getLastName());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getUsername());
			pstmt.setString(5, user.getPassword());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			log.error("User not created.");
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(User user) {
		log.trace("Delete User Called");
		
		Connection conn = ConnectionFactoryPostgres.getConnection();
		
		String sql = "delete from users where username = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			log.error("User not created.");
			e.printStackTrace();
		}

	}

	@Override
	public User getUserByName(String username) {		
		log.trace("Getting user by username");
		
		User user = null;
		
		Connection conn = ConnectionFactoryPostgres.getConnection();
		
		String sql = "select * from users where username = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				//log.info("User found in DB");
				user = new User();
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("pass_word"));
			}
		} catch (SQLException e) {
			//log.error("User not found. Connection failed.");
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public void updatePassword(User user, String password) {
		log.trace("Update Password called");
		
		Connection conn = ConnectionFactoryPostgres.getConnection();
		
		String sql = "update users set pass_word = ? where username = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, user.getUsername());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			log.error("Password not updated. Connection failed.");
			e.printStackTrace();
		}
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
