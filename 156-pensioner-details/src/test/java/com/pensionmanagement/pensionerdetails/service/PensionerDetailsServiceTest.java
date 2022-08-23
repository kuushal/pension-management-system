package com.pensionmanagement.pensionerdetails.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import com.pensionmanagement.pensionerdetails.models.PensionerDetails;

@AutoConfigureMockMvc
@SpringBootTest(classes = PensionerDetailsServiceTest.class)
public class PensionerDetailsServiceTest {

	@InjectMocks
	private PensionerDetailsServiceImpl pensionerDetailsServiceImpl;

	@Test
	public void testNotNullPensionDetailServiceObject() {
		assertNotNull(pensionerDetailsServiceImpl);
	}

	@Test
	public void testPensionerDetailFunction() {
		PensionerDetails pensionerDetail = new PensionerDetails("123456780000", "Mike", "2-2-1992", "UHGET0000A",
				50000.0, 12000.0, "family","9876543210", "ICICI", "private" );
		
		assertThat(assertThat(pensionerDetail).isNotNull());

		assertEquals("123456780000", pensionerDetail.getAadhaarNumber());
		assertEquals("2-2-1992", pensionerDetail.getDateOfBirth());
		assertEquals("Mike", pensionerDetail.getName());
		assertEquals("UHGET0000A", pensionerDetail.getPanNumber());
		assertEquals(50000, pensionerDetail.getSalary());
		assertEquals(12000, pensionerDetail.getAllowance());
		assertEquals("family", pensionerDetail.getPensionType());
		assertEquals("9876543210", pensionerDetail.getAccountNumber());
		assertEquals("ICICI",pensionerDetail.getBankName());
		assertEquals("private",pensionerDetail.getTypeOfBank());
		
	}

}
