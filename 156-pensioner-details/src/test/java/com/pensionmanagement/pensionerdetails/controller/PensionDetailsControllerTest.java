package com.pensionmanagement.pensionerdetails.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.pensionmanagement.pensionerdetails.feing.AuthenticationProxy;
import com.pensionmanagement.pensionerdetails.models.PensionerDetails;
import com.pensionmanagement.pensionerdetails.models.ValidityResponse;
import com.pensionmanagement.pensionerdetails.service.PensionerDetailsService;

@AutoConfigureMockMvc
@SpringBootTest
public class PensionDetailsControllerTest {

	@Autowired
	private PensionDetailsController pensionDetailsController;
	
	@MockBean
	private AuthenticationProxy authenticationProxy;
	
	@MockBean
	private PensionerDetailsService pensionerDetailsService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testAuthenticationProxyNotNull() {
		assertThat(authenticationProxy).isNotNull();
	}

	@Test
	public void testNotNullPensionDetailsController() throws Exception {
		assertThat(pensionDetailsController).isNotNull();
	}
	
	@Test
	public void testController() throws Exception {
		ValidityResponse details = new ValidityResponse("", true);
		when(authenticationProxy.getValidity("token")).thenReturn(details);
		PensionerDetails detail = new PensionerDetails();
		when(pensionerDetailsService.getPensionerDetails("111111111111")).thenReturn(detail);
		mockMvc.perform(get("/pensionerDetails/111111111111").header("Authorization",
				"token")).andExpect(status().isOk());
	}
	
	@Test
	public void invalidParamPassTest() throws Exception {
		String values = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJSYWFnYXZpIiwiZXhwIjoxNjUyMTkyODQxLCJpYXQiOjE2NTIxOTEwNDF9.U9tKmQ7F9bQ-qxytjlwfMglyiHJMrbrs3NoB32CYQm4";
		mockMvc.perform(get("/pensionerDetails?aadhaarNumber=").header("Authorization",
				"Bearer " + values)).andExpect(status().is4xxClientError());
	}
	
	@Test
	public void testGetBadRequest() throws Exception {
		String values = "";
		mockMvc.perform(get("/pensionerDetails?aadhaarNumber=").header("Authorization",
				"Bearer " + values)).andExpect(status().is4xxClientError());
	}
	
	@Test
	public void testGetBadRequest2() throws Exception {
		mockMvc.perform(get("/pensionerDetails?aadhaarNumber="))
				.andExpect(status().is4xxClientError());
	}
	
	@Test
	public void TestToken() {
		ValidityResponse validityResponse = new ValidityResponse();
		String token = "";
		validityResponse.setValid(true);
		validityResponse.setToken(token);
		assertEquals(validityResponse.getToken(), token);
	}



}
