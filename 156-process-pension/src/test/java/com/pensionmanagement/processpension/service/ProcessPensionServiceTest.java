package com.pensionmanagement.processpension.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.pensionmanagement.processpension.model.BankDetails;
import com.pensionmanagement.processpension.model.PensionDetails;
import com.pensionmanagement.processpension.model.ProcessPensionInput;

@SpringBootTest(classes=ProcessPensionServiceTest.class)
@AutoConfigureMockMvc
public class ProcessPensionServiceTest {
	
	@InjectMocks
	private ProcesPensionServiceImpl processPensionServiceImpl;
	
	@Test
	public void testNotNullProcesPensionServiceImplObject() {
		assertNotNull(processPensionServiceImpl);
	}
	
	@Test
	public void testPensionAmountFunction() {
		
		PensionDetails pensionerDetail = new PensionDetails("123456780000",50000,20000);
		
		ProcessPensionInput inputFamily=new ProcessPensionInput("123456780000", "Mike", "2-2-1992", "UHGET0000A",
				50000, 20000, "family", "ICICI", "9876543210", "private");
		
		ProcessPensionInput inputSelf=new ProcessPensionInput("123422220000", "John", "2-2-1990", "UHGET0000A",
				50000, 20000, "self", "ICICI", "9876543210", "private");

		assertNotNull(pensionerDetail);
		assertThat(assertThat(inputFamily).isNotNull());
		assertThat(assertThat(inputSelf).isNotNull());

		assertEquals(45000, processPensionServiceImpl.pensionAmount(inputFamily));
		assertEquals(60000, processPensionServiceImpl.pensionAmount(inputSelf));
	} 
	
	
	
	@Test
	public void testbankServiceChargeFunction() {
		
		ProcessPensionInput inputPrivate=new ProcessPensionInput("123456780000", "Mike", "2-2-1992", "UHGET0000A",
				50000, 20000, "family", "ICICI", "9876543210", "private");
		
		ProcessPensionInput inputPublic=new ProcessPensionInput("123422220000", "John", "2-2-1990", "UHGET0000A",
				50000, 20000, "self", "SBI", "1234567789", "public");

		assertThat(assertThat(inputPrivate).isNotNull());
		assertThat(assertThat(inputPublic).isNotNull());

		assertEquals(550, processPensionServiceImpl.bankServiceCharge(inputPrivate));
		assertEquals(500, processPensionServiceImpl.bankServiceCharge(inputPublic));
	} 
	
}
