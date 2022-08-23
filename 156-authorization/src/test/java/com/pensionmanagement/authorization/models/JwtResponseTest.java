package com.pensionmanagement.authorization.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes=JwtResponse.class)
public class JwtResponseTest {
	
	private JwtResponse response;
	
	@BeforeEach
	void setUp() throws Exception {
		
		response = new JwtResponse("token",true);  
	}

	@Test
	void test() {
		assertThat(response.getToken().equals("token"));
		assertTrue(response.isValid());
	}
}
