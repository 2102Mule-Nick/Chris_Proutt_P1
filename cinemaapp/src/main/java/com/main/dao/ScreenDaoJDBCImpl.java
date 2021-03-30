package com.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.main.dao.mapper.ScreenRowMapper;
import com.main.pojo.Screen;
import com.main.pojo.Theater;

@Repository
public class ScreenDaoJDBCImpl implements ScreenDao {

	private JdbcTemplate template;
	
	private ScreenRowMapper mapper;
	
	private TheaterDao theaterdao;
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public ScreenRowMapper getMapper() {
		return mapper;
	}
	
	@Autowired
	public void setMapper(ScreenRowMapper mapper) {
		this.mapper = mapper;
	}

	public TheaterDao getTheaterdao() {
		return theaterdao;
	}

	@Autowired
	public void setTheaterdao(TheaterDao theaterdao) {
		this.theaterdao = theaterdao;
	}

	@Override
	public void createScreen(Screen screen) {
		
		String sql = "insert into screen (theater_id, capacity, screen_type) values (?, ?, ?)";
		
		template.update(sql, screen.getTheater_id(), screen.getCapacity(), screen.getScreen_type());

	}

	@Override
	public void deleteScreen(Screen screen) {
		String sql = "delete from screen where screen_id = ?";
		
		template.update(sql, screen.getScreen_id());
				
	}

	@Override
	public Screen getScreenById(int id) {
		String sql = "select * from screen where screen_id = ?";
		
		List<Screen> screenList = template.query(sql, mapper, id);
		
		return screenList.get(0);
	}

	@Override
	public List<Screen> getAllScreensAtTheater(Theater theater) {
		String sql = "select * from screen where theater_id = ?";
		
		List<Screen> screenList = template.query(sql, mapper, theater.getTheater_id()) ;
		
		return screenList;
	}

	@Override
	public List<Screen> getAllScreens() {
		String sql = "select * from screen";
		
		List<Screen> screenList = template.query(sql, mapper);
		
		return screenList;
	}

}
