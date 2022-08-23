package com.pensionmanagement.authorization.models;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = JwtRequest.class)
public class JwtRequestTest {

	private JwtRequest request = new JwtRequest("admin", "password");

	@Test
	void testUserNameGetter() {
		assertThat(request.getUsername().equals("admin")).isTrue();
	}

}
