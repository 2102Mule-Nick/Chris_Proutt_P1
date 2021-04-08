package com.main;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.sql.DataSource;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.main") // searches in that package, and any nested packages for Spring annotations
@EnableAspectJAutoProxy
@EnableJms
@EnableTransactionManagement
public class AppConfig {
	// JMS Broker Url
		public static final String BROKER_URL = "tcp://localhost:61616";
		
		// Destinations
		public static final String SHOWTIME_QUEUE = "Showtime_Queue";
	
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
		public ActiveMQConnectionFactory amqConnectionFactory() {
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
			connectionFactory.setBrokerURL(BROKER_URL);
			return connectionFactory;
		}
		
		@Bean
		public ConnectionFactory connectionFactory(ActiveMQConnectionFactory amqConnectionFactory) {
			return new SingleConnectionFactory(amqConnectionFactory);
		}
		
		@Bean 
		public Queue ScreenQueue() {
			return new ActiveMQQueue(SHOWTIME_QUEUE);
		}
		
		@Bean
		public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory) {
			DefaultJmsListenerContainerFactory container = new DefaultJmsListenerContainerFactory();
			container.setConnectionFactory(connectionFactory);
			return container;
		}
}
