package com.pensionmanagement.processpension.service;

import org.springframework.stereotype.Service;

import com.pensionmanagement.processpension.model.ProcessPensionInput;

@Service
public class ProcesPensionServiceImpl implements ProcessPensionService {

	@Override
	public double pensionAmount(ProcessPensionInput pensionerInput) {
		double pensionAmount=0;
		
		if (pensionerInput.getPensionType().equalsIgnoreCase("self")) {
			pensionAmount = (0.8 * pensionerInput.getSalary() + pensionerInput.getAllowance());

		} else if (pensionerInput.getPensionType().equalsIgnoreCase("family")){
			pensionAmount = (0.5 * pensionerInput.getSalary() + pensionerInput.getAllowance());
		}
		
		return pensionAmount;
	}

	@Override
	public double bankServiceCharge(ProcessPensionInput pensionerInput) {
		double bankServiceCharge=0;

		if (pensionerInput.getTypeOfBank().equalsIgnoreCase("private")) {
			bankServiceCharge = 550;
		} else if (pensionerInput.getTypeOfBank().equalsIgnoreCase("public")){
			bankServiceCharge = 500;
		}
		return bankServiceCharge;
	}
}
