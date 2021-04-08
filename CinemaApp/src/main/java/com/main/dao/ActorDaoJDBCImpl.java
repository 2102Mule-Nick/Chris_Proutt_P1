package com.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.main.dao.mapper.ActorRowMapper;
import com.main.pojo.Actor;

@Repository
public class ActorDaoJDBCImpl implements ActorDao {

	private JdbcTemplate template;
	
	private ActorRowMapper mapper;
	
	private CharacterDao characterDao;
		
	public JdbcTemplate getTemplate() {
		return template;
	}

	public ActorRowMapper getMapper() {
		return mapper;
	}

	public CharacterDao getCharacterDao() {
		return characterDao;
	}

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Autowired
	public void setMapper(ActorRowMapper mapper) {
		this.mapper = mapper;
	}

	@Autowired
	public void setCharacterDao(CharacterDao characterDao) {
		this.characterDao = characterDao;
	}

	@Override
	public void addActor(Actor actor) {
		String sql = "insert into actors (first_name, last_name) values (?, ?)";
		template.update(sql, actor.getFirstName(), actor.getLastName());
	}

	@Override
	public void deleteActor(Actor actor) {
		String sql = "delete from actors where actor_id = ?";
		template.update(sql, actor.getActor_id());
	}

	@Override
	public List<Actor> getActorsFromMovie(int movieId) {
		String sql = "select * from actors where actor_id = "
				+ "(select actor_id from characters where movie_id = ?)";
		List<Actor> actorList = template.query(sql, mapper, movieId);
		
		return actorList;
	}

}
