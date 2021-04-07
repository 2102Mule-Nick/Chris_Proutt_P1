package com.main;

import java.util.Properties;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.sql.DataSource;
import javax.transaction.TransactionManager;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.main.messaging.JmsMessageListener;

import bitronix.tm.TransactionManagerServices;
import bitronix.tm.resource.jdbc.PoolingDataSource;
import bitronix.tm.resource.jms.PoolingConnectionFactory;

@Configuration
@ComponentScan("com.main")
@EnableJms
@EnableAspectJAutoProxy
public class AppConfig {

	// JMS Broker Url
	public static final String BROKER_URL = "tcp://localhost:61616";
	
	// Destinations
	public static final String Seat_Queue = "Seat_Queue";
	public static final String Movie_Topic = "Movie_Topic";
	
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
	public ConnectionFactory bitronixConnectionFactory() {
		PoolingConnectionFactory connectionFactory = new PoolingConnectionFactory();
		connectionFactory.setClassName("org.apache.activemq.ActiveMQXAConnectionFactory");
		connectionFactory.setUniqueName("activemq");
		connectionFactory.setMaxPoolSize(10);
		connectionFactory.setAllowLocalTransactions(true);
		Properties props = new Properties();
		props.put("brokerURL", BROKER_URL);
		connectionFactory.setDriverProperties(props);
		return connectionFactory;
	}
	
	@Bean 
	public Queue SeatQueue() {
		return new ActiveMQQueue(Seat_Queue);
	}
	
	@Bean
	public Topic MovieTopic() {
		return new ActiveMQTopic(Movie_Topic);
	}
		
	@Bean
	public JmsTemplate jmsTemplate(ConnectionFactory bitronixConnectionFactory) {
		JmsTemplate jmsTemplate = new JmsTemplate();
		jmsTemplate.setConnectionFactory(bitronixConnectionFactory);
		jmsTemplate.setReceiveTimeout(10000);
		return jmsTemplate;
	}
	
	@Bean
	public DefaultMessageListenerContainer jmsContainer(ConnectionFactory connectionFactory,
			JmsMessageListener messageListener) {
		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setDestinationName(Seat_Queue);
		container.setMessageListener(messageListener);
		return container;
	}
	
	@Bean
	public bitronix.tm.Configuration btmConfig() {
		bitronix.tm.Configuration config = TransactionManagerServices.getConfiguration();
		config.setDisableJmx(true);
		config.setServerId("spring-btm");
		return config;
	}

	@Bean(destroyMethod = "shutdown")
	@DependsOn("btmConfig")
	public TransactionManager primaryTransactionManager() {
		return TransactionManagerServices.getTransactionManager();
	}

	@Bean
	public JtaTransactionManager jtaTransactionManager(TransactionManager primaryTransactionManager) {
		JtaTransactionManager jtaTransactionManager = new JtaTransactionManager();
		jtaTransactionManager.setTransactionManager(primaryTransactionManager);
		return jtaTransactionManager;
	}
	
	@Bean
	public Logger log() {
		return Logger.getRootLogger();
	}
}
