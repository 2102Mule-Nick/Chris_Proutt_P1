package com.main.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.main.utilities.ConnectionFactoryPostgres;

class ConnectionFactoryTest {

	@Test
	void test() {
		assertNotNull(ConnectionFactoryPostgres.getConnection());
	}

}
