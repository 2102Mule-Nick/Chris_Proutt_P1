package com.main.config;

import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.main") // searches in that package, and any nested packages for Spring annotations
@Component("config")
//@EnableAspectJAutoProxy
public class AppConfig {

	//DataSource info
	public static final String DATASOURCE_URL = 
			"jdbc:postgresql://" + 
			System.getenv("DB_URL") + 
			":5432/" + 
			System.getenv("DB_NAME") + 
			"?";
	public static final String DATASOURCE_DRIVERNAME = "org.postgresql.Driver";
	public static final String DATASOURCE_USERNAME = System.getenv("DB_USERNAME");
	public static final String DATASOURCE_PASSWORD = System.getenv("DB_PASSWORD");
	public static final String DATASOURCE_SCHEMA = "public";
	

	
	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(DATASOURCE_URL);
		dataSource.setDriverClassName(DATASOURCE_DRIVERNAME);
		dataSource.setUsername(DATASOURCE_USERNAME);
		dataSource.setPassword(DATASOURCE_PASSWORD);
		dataSource.setSchema(DATASOURCE_SCHEMA);
		return dataSource;
		
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(dataSource);
		return template;
	}

	@Bean
	public Logger log() {
		return Logger.getRootLogger();
	}
}