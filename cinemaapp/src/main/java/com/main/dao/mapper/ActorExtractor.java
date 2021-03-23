package com.main.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.main.pojo.Actor;

@Component
public class ActorExtractor implements ResultSetExtractor<Actor> {

	@Override
	public Actor extractData(ResultSet rs) throws SQLException, DataAccessException {
		Actor actor = new Actor();
		
		actor.setActor_id(rs.getInt("actor_id"));
		actor.setFirstName(rs.getString("first_name"));
		actor.setLastName(rs.getString("last_name"));
		
		return actor;
	}

}
