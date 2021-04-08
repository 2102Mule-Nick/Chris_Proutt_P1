package com.main;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.sql.DataSource;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import bitronix.tm.resource.jdbc.PoolingDataSource;

@Configuration
@ComponentScan("com.main")
@EnableJms
@EnableAspectJAutoProxy
@EnableWebMvc
@Component("config")
public class AppConfig {
	
	// JMS Broker Url
		public static final String BROKER_URL = "tcp://localhost:61616";
		
		// Destinations
		public static final String SHOWTIME_QUEUE = "Showtime_Queue";
		
		// DataSource info
		public static final String DATASOURCE_SCHEMA = "public";
		public static final String DATASOURCE_URL = "jdbc:postgresql://" + System.getenv("DB_URL") + ":5432/"
				+ System.getenv("DB_NAME");
		public static final String DATASOURCE_DRIVERNAME = "org.postgresql.xa.PGXADataSource";
		public static final String DATASOURCE_USERNAME = System.getenv("DB_USERNAME");
		public static final String DATASOURCE_PASSWORD = System.getenv("DB_PASSWORD");
		
		@Bean(destroyMethod = "close")
		public DataSource dataSource() {
			System.out.println(DATASOURCE_URL);
			PoolingDataSource dataSource = new PoolingDataSource();
			dataSource.setClassName(DATASOURCE_DRIVERNAME);
			dataSource.setUniqueName("PostGresDB");
			dataSource.setMaxPoolSize(10);
			dataSource.setAllowLocalTransactions(true);
			dataSource.getDriverProperties().put("Url", DATASOURCE_URL);
			dataSource.getDriverProperties().put("user", DATASOURCE_USERNAME);
			dataSource.getDriverProperties().put("password", DATASOURCE_PASSWORD);
			dataSource.init();
			return dataSource;

		}
		
		@Bean
		public JdbcTemplate jdbcTemplate(DataSource dataSource) {
			return new JdbcTemplate(dataSource);
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
		public Queue ShowtimeQueue() {
			return new ActiveMQQueue(SHOWTIME_QUEUE);
		}
		
		@Bean
		public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory) {
			DefaultJmsListenerContainerFactory container = new DefaultJmsListenerContainerFactory();
			container.setConnectionFactory(connectionFactory);
			return container;
		}
		
		@Bean
		public Logger log() {
			PropertyConfigurator.configure(getClass().getResourceAsStream("/log4j.properties"));
			Logger log = Logger.getRootLogger();
			return log;
		}
}
