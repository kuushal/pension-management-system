package com.pensionmanagement.authorization.config;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;

@SpringBootTest
public class JwtTokenUtilTest {
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@MockBean
	private Claims claim;
	
	UserDetails userDetails;
	
	@Test
	void testGenerateTokenWithRandomUserGeneratesNull() {
		UserDetails details = new org.springframework.security.core.userdetails.User("admin", "pass",
				new ArrayList<>());
		assertThat(jwtTokenUtil.generateToken(details)).isNotNull();
	}
	
	
	@Test
	void validateTokenTest() {
		userDetails = new User("admin", "admin", new ArrayList<>());
		String generateToken = jwtTokenUtil.generateToken(userDetails);
		Boolean validateToken = jwtTokenUtil.validateToken(generateToken);
		assertThat(validateToken).isTrue();
	}
	
}
