package com.pensionmanagement.processpension.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pensionmanagement.processpension.model.BankDetails;
import com.pensionmanagement.processpension.model.PensionDetails;
import com.pensionmanagement.processpension.model.ProcessPensionInput;


@SpringBootTest
public class ModelTest {
	
	@Test
	void NoArgsBankDetailTest() {
		assertThat(new BankDetails()).isNotNull();
	}
	
	@Test
	void NoArgSetterBankDetailsTest() {
		BankDetails b = new BankDetails();
		b.setAccountNumber("9876543210");
		b.setBankName("ICICI");
		b.setTypeOfBank("private");
		assertThat(assertThat(b).isNotNull());
	}
	
	@Test
	void SetterArgsBankDetailTest() {
		BankDetails bankDetails = new BankDetails("ICICI", "9876543210", "private") ;
		assertEquals("ICICI", bankDetails.getBankName()) ;
		assertEquals("9876543210", bankDetails.getAccountNumber()) ;
		assertEquals("private", bankDetails.getTypeOfBank()) ;
	}
	
	@Test
	void testSetterProcessPensionInputTest() {
		ProcessPensionInput input = new ProcessPensionInput();
		input.setAadhaarNumber("123456780000");
		input.setDateOfBirth("2-2-1992");
		input.setName("Mike");
		input.setPanNumber("UHGET0000A");
		input.setSalary(50000);
		input.setAllowance(12000);
		input.setPensionType("family");
		input.setAccountNumber("9876543210");
		input.setBankName("ICICI");
		input.setTypeOfBank("private");

		assertThat(assertThat(input).isNotNull());
		
		assertEquals("123456780000",input.getAadhaarNumber() ) ;
		assertEquals("2-2-1992", input.getDateOfBirth()) ;
		assertEquals("Mike", input.getName()) ;
		assertEquals("UHGET0000A", input.getPanNumber()) ;
		assertEquals(50000, input.getSalary()) ;
		assertEquals(12000, input.getAllowance()) ;
		assertEquals("family", input.getPensionType()) ;
		
		assertEquals("9876543210",input.getAccountNumber() ) ;
		assertEquals("ICICI", input.getBankName()) ;
		assertEquals("private",input.getTypeOfBank() ) ;
		
	}
	
	@Test
	void testSetterPensionDetailsTest() {
		PensionDetails details=new PensionDetails("123456780000",50000,550);
		assertThat(assertThat(details).isNotNull());
		
		assertEquals("123456780000", details.getAadhaarNumber());
		assertEquals(50000, details.getPensionAmount());
		assertEquals(550, details.getBankCharge());
		
	}
}
