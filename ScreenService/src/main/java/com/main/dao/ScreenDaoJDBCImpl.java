package com.main.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.main.dao.mapper.ScreenRowMapper;
import com.main.pojo.Screen;

@Repository
public class ScreenDaoJDBCImpl implements ScreenDao {

	private JdbcTemplate template;
	
	private ScreenRowMapper mapper;
		
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

	public Screen createScreen(Screen screen) {
		String sql = "insert into screen (theater_id, capacity, screen_type, screen_name) values (?, ?, ?, ?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		template.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, screen.getTheater_id());
			ps.setInt(2, screen.getCapacity());
			ps.setString(3, screen.getScreen_type());
			ps.setString(4, screen.getScreen_name());
			return ps;
		}, keyHolder);
	
		screen.setScreen_id((int)keyHolder.getKeys().get("screen_id"));
			
		return screen;
	}

	public void deleteScreen(int id) {
		String sql = "delete from screen where screen_id = ?";
		
		template.update(sql, id);		
	}

	public Screen getScreenById(int id) {
		String sql = "select * from screen where screen_id = ?";
		
		List<Screen> screenList = template.query(sql, mapper, id);
		
		return screenList.get(0);
	}
	
	public Screen getScreenByTheaterIdandScreenName(int theaterId, String screenName) {
		String sql = "select * from screen where theater_id = ? and screen_name = ?";
		
		List<Screen> screenList = template.query(sql, mapper, theaterId, screenName);
		
		return screenList.get(0);
	}

	public void setScreenType(int id, String string) {
		String sql = "update screen set screen_type = ? where screen_id = ?";
		template.update(sql, string, id);
	}

	public List<Screen> getAllScreens() {
		String sql = "select * from screen";
		
		List<Screen> screenList = template.query(sql, mapper);
		
		return screenList;
	}

	public List<Screen> getAllScreensAtTheater(int theaterId) {
		String sql = "select * from screen where theater_id = ?";
		
		List<Screen> screenList = template.query(sql, mapper, theaterId) ;
		
		return screenList;
	}

	@Override
	public Screen getScreenByName(String screenName) {
		String sql = "select * from screen where screen_name = ?";
		
		List<Screen> screenList = template.query(sql, mapper, screenName);
		
		return screenList.get(0);
		
	}

}
