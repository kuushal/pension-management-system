package com.pensionmanagement.pensionerdetails.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ModelTest {
	
	@Test
	void NoArgsBankDetailTest() {
		assertThat(new BankDetails()).isNotNull();
	}
	
	@Test
	void AllArgsBankDetailTest() {
		BankDetails bankDetails = new BankDetails("ICICI", "9876543210", "Private") ;
		assertNotNull(bankDetails) ;
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
	void testSetterPensionerDetailTest() {
		PensionerDetails pensionerDetail = new PensionerDetails();
		pensionerDetail.setAadhaarNumber("123456780000");
		pensionerDetail.setDateOfBirth("2-2-1992");
		pensionerDetail.setName("Mike");
		pensionerDetail.setPanNumber("UHGET0000A");
		pensionerDetail.setSalary(50000);
		pensionerDetail.setAllowance(12000);
		pensionerDetail.setPensionType("family");
		pensionerDetail.setAccountNumber("9876543210");
		pensionerDetail.setBankName("ICICI");
		pensionerDetail.setTypeOfBank("private");

		assertThat(assertThat(pensionerDetail).isNotNull());
		
		assertEquals("123456780000",pensionerDetail.getAadhaarNumber() ) ;
		assertEquals("2-2-1992", pensionerDetail.getDateOfBirth()) ;
		assertEquals("Mike", pensionerDetail.getName()) ;
		assertEquals("UHGET0000A", pensionerDetail.getPanNumber()) ;
		assertEquals(50000, pensionerDetail.getSalary()) ;
		assertEquals(12000, pensionerDetail.getAllowance()) ;
		assertEquals("family", pensionerDetail.getPensionType()) ;
		assertEquals("9876543210",pensionerDetail.getAccountNumber() ) ;
		assertEquals("ICICI", pensionerDetail.getBankName()) ;
		assertEquals("private",pensionerDetail.getTypeOfBank() ) ;
		
	}
}
