package com.main.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.main.utilities.ConnectionFactoryPostgres;

class ConnectionFactoryTest {

	@Test
	void test() {
		assertNotNull(ConnectionFactoryPostgres.getConnection());
	}

}
