package com.pensionmanagement.authorization.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pensionmanagement.authorization.config.JwtTokenUtil;
import com.pensionmanagement.authorization.models.JwtRequest;
import com.pensionmanagement.authorization.models.UserModel;
import com.pensionmanagement.authorization.service.JwtUserDetailsService;
import com.pensionmanagement.authorization.service.LoginService;
import com.pensionmanagement.authorization.service.ValidationService;

@SpringBootTest(classes = JwtAuthenticationController.class)
@AutoConfigureMockMvc
public class JwtAuthenticationControllerTest {

	private String token;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private JwtAuthenticationController authenticationController;

	@MockBean
	private LoginService loginService;

	@MockBean
	private ValidationService validationService;

	@MockBean
	private JwtTokenUtil jwtTokenUtil;

	@MockBean
	private JwtUserDetailsService userDetailsService;

	@MockBean
	private AuthenticationManager authenticationManager;

	@Test
	public void contextLoads() {
		assertNotNull(authenticationController);
	}

	@Test
	void testBadRequestGenerateToken() throws Exception {
		this.mockMvc.perform(post("/authenticate")).andExpect(status().is4xxClientError());
	}

	@Test
	void testAuthorizedGenerateToken() throws Exception {

		UserModel user = new UserModel("admin", "test123");

		UserDetails details = new org.springframework.security.core.userdetails.User(user.getUsername(),
				user.getPassword(), new ArrayList<>());

		when(jwtTokenUtil.generateToken(details)).thenReturn("Bearer @token@token");
		when(userDetailsService.loadUserByUsername("admin")).thenReturn(details);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(new JwtRequest("admin", "test123"));
		this.mockMvc.perform(post("/authenticate").contentType(MediaType.APPLICATION_JSON).content(jsonString))
				.andExpect(status().isForbidden());
	}

	@Test
	void testBadRequest() throws Exception {
		this.mockMvc.perform(post("/authenticate")).andExpect(status().isForbidden());
	}

	@Test
	void testRandomUrl() throws Exception {
		this.mockMvc.perform(get("/other/url")).andExpect(status().isUnauthorized());
	}

	@Test
	void textExistingUserAuthenticate() throws Exception {
		UserModel user = new UserModel("admin", "test123");
		UserDetails details = new org.springframework.security.core.userdetails.User(user.getUsername(),
				user.getPassword(), new ArrayList<>());
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				"admin", "test123");
		when(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken("admin", "admin")))
				.thenReturn(usernamePasswordAuthenticationToken);
		when(userDetailsService.loadUserByUsername("admin")).thenReturn(details);
		when(jwtTokenUtil.getUsernameFromToken("token")).thenReturn("admin");
		when(jwtTokenUtil.generateToken(details)).thenReturn("token");
		ObjectMapper mapper = new ObjectMapper();
		mockMvc.perform(MockMvcRequestBuilders.post("/authenticate").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(new JwtRequest("admin", "test123"))))
				.andExpect(status().isForbidden());

	}

	String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

}
