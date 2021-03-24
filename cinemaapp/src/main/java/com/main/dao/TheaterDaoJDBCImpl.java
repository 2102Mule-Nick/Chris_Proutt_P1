package com.main.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.main.dao.mapper.TheaterRowMapper;
import com.main.pojo.Theater;

@Repository
public class TheaterDaoJDBCImpl implements TheaterDao {
	
	@Autowired
	Logger log;
	
	private JdbcTemplate template;
	
	private TheaterRowMapper mapper;
	
	@Override
	public void createTheater(Theater theater) {
		log.trace("create theater method called.");

		String sql = "insert * into theater (theater_name, theater_address, num_of_screens) values (?, ?, ?) ";
		
		template.update(sql, theater.getTheaterName(), theater.getAddress(), theater.getNum_of_screens());
	}

	@Override
	public void deleteTheater(Theater theater) {
		log.trace("Deleting a theater");
		
		String sql = "delete from theater where theater_id = ?";
	
		template.update(sql, theater.getTheater_id());
	}

	@Override
	public Theater getTheaterById(int id) {
		log.trace("Getting theater by Id");
		
		String sql = "select * from theater where theater_id = ?";
		
		List<Theater> theaterList = template.query(sql, mapper, id);
		
		return theaterList.get(0);
	}

	@Override
	public List<Theater> getAllTheaters() {
		log.trace("Getting all theaters");
		
		String sql = "select * from theater";
		
		List<Theater> theaterList = template.query(sql, mapper); 
		
		return theaterList;
	}

}
