package com.pensionmanagement.processpension.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pensionmanagement.processpension.feing.AuthenticationProxy;
import com.pensionmanagement.processpension.feing.PensionerDetailsProxy;
import com.pensionmanagement.processpension.model.ProcessPensionInput;
import com.pensionmanagement.processpension.model.ValidityResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ProcessPensionControllerTest {

	@MockBean
	private ProcessPensionController controller;

	@MockBean
	private AuthenticationProxy authenticationProxy;

	@MockBean
	private PensionerDetailsProxy pensionerDetailsProxy;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void TestController() {
		assertThat(controller).isNotNull();
	}

	@Test
	public void TestAuthenticationProxyNotNull() {
		assertThat(authenticationProxy).isNotNull();
	}

	@Test
	public void TestPensionerDetailsProxyNotNull() {
		assertThat(pensionerDetailsProxy).isNotNull();
	}

	@Test
	void testMockMvcNotNull() {
		assertThat(mockMvc).isNotNull();
	}

	String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

	@Test
	void checkController() throws Exception {
		when(authenticationProxy.getValidity("token")).thenReturn(new ValidityResponse("", true));
		ProcessPensionInput input = new ProcessPensionInput("111111111111");
		ProcessPensionInput input1 = new ProcessPensionInput();
		input1.setAadhaarNumber("123456780000");
		input1.setDateOfBirth("2-2-1992");
		input1.setName("Mike");
		input1.setPanNumber("UHGET0000A");
		input1.setSalary(50000);
		input1.setAllowance(12000);
		input1.setPensionType("family");
		input1.setAccountNumber("9876543210");
		input1.setBankName("ICICI");
		input1.setTypeOfBank("private");
		String jsonPensionerInput=this.mapToJson(input1);
		when(pensionerDetailsProxy.findByAadhaarNumber("token", input1.getAadhaarNumber())).thenReturn(input1);
		mockMvc.perform(post("/ProcessPension").contentType("application/json").content(jsonPensionerInput)
				.header("Authorization", "token")).andExpect(status().isOk());
	}

}
