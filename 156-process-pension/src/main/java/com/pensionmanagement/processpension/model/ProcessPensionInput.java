package com.pensionmanagement.processpension.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProcessPensionInput {
	
	private String aadhaarNumber;						
	private String name;								
	private String dateOfBirth;							
	private String panNumber;							
	private double salary;								
	private double allowance;							
	private String pensionType;							
	private String accountNumber;
	private String bankName;
	private String typeOfBank;
	
	public ProcessPensionInput(String aadhaarNumber) {
		super();
		this.aadhaarNumber = aadhaarNumber;
	}
}
