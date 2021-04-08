package com.main.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.main.dao.mapper.TheaterRowMapper;
import com.main.pojo.Theater;

@Repository
public class TheaterDaoJDBCImpl implements TheaterDao {
	
	@Autowired
	Logger log;
	
	private JdbcTemplate template;
	
	private TheaterRowMapper mapper;
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public TheaterRowMapper getMapper() {
		return mapper;
	}

	@Autowired
	public void setMapper(TheaterRowMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public Theater createTheater(Theater theater) {
		String sql = "insert * into theater (theater_name, theater_address, zip_code, num_of_screens) values (?, ?, ?, ?) ";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		template.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, theater.getTheaterName());
			ps.setString(2, theater.getAddress());
			ps.setString(3, theater.getZipcode());
			ps.setInt(4, theater.getNum_of_screens());
			return ps;
		}, keyHolder);
		
		theater.setTheater_id((int)keyHolder.getKeys().get("theater_id"));
		
		return theater;
	}

	@Override
	public void deleteTheater(int theaterid) {		
		String sql = "delete from theater where theater_id = ?";
	
		template.update(sql, theaterid);
	}
	
	@Override
	public void deleteAllTheaters() {
		String sql = "delete from theater";
		
		template.update(sql);
	}

	@Override
	public Theater getTheaterById(int id) {		
		String sql = "select * from theater where theater_id = ?";
		
		List<Theater> theaterList = template.query(sql, mapper, id);
		
		return theaterList.get(0);
	}
	
	@Override
	public Theater getTheaterByName(String name) {		
		String sql = "select * from theater where theater_name = ?";
		
		List<Theater> theaterList = template.query(sql, mapper, name);
		
		return theaterList.get(0);
	}

	@Override
	public List<Theater> getAllTheaters() {		
		String sql = "select * from theater";
		
		List<Theater> theaterList = template.query(sql, mapper); 
		
		return theaterList;
	}

	@Override
	public void updateTheaterName(int theaterId, String name) {
		String sql = "update theater set theater_name = ? where theater_id = ?";
		
		template.update(sql, name, theaterId);
	}

	@Override
	public void updateTheaterAddress(int theaterId, String address) {
		String sql = "update theater set theater_address = ? where theater_id = ?";
		
		template.update(sql, address, theaterId);		
	}

	@Override
	public void updateTheaterZipCode(int theaterId, String zipcode) {
		String sql = "update theater set zip_code = ? where theater_id = ?";
		
		template.update(sql, zipcode, theaterId);		
	}

	@Override
	public void updateNumberOfScreens(int theaterId, int screens) {
		String sql = "update theater set num_of_screens = ? where theater_id = ?";
		
		template.update(sql, screens, theaterId);		
	}

}
