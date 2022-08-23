package com.pensionmanagement.processpension.service;

import com.pensionmanagement.processpension.model.ProcessPensionInput;

public interface ProcessPensionService {
	
	public double pensionAmount(ProcessPensionInput pensionerInput);
	
	public double bankServiceCharge(ProcessPensionInput pensionerInput);

}
