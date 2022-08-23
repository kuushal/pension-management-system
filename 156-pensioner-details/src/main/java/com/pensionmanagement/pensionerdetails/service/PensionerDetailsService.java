package com.pensionmanagement.pensionerdetails.service;

import com.pensionmanagement.pensionerdetails.models.PensionerDetails;

public interface PensionerDetailsService {

	public void loadPensionerDetails();
	
	public PensionerDetails getPensionerDetails(String aadharNumber);
}
