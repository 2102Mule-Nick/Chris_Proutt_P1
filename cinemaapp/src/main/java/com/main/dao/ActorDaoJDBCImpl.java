package com.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.main.dao.mapper.ActorRowMapper;
import com.main.pojo.Actor;
import com.main.pojo.Movie;

@Repository
public class ActorDaoJDBCImpl implements ActorDao {

	private JdbcTemplate template;
	
	private ActorRowMapper mapper;
	
	private CharacterDao characterDao;
	
	private MovieDao movieDao;
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	public ActorRowMapper getMapper() {
		return mapper;
	}

	public CharacterDao getCharacterDao() {
		return characterDao;
	}

	public MovieDao getMovieDao() {
		return movieDao;
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

	@Autowired
	public void setMovieDao(MovieDao movieDao) {
		this.movieDao = movieDao;
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
	public List<Actor> getActorsFromMovie(Movie movie) {
		String sql = "select * from actors where actor_id = "
				+ "(select actor_id from characters where movie_id = ?)";
		List<Actor> actorList = template.query(sql, mapper, movie.getMovie_id());
		
		return actorList;
	}

}
