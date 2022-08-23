package com.pensionmanagement.processpension.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class BankDetails {
	
	private String bankName;
	private String accountNumber;
	private String typeOfBank;
	
	public BankDetails(String bankName, String accountNumber, String typeOfBank) {
		super();
		this.bankName = bankName;
		this.accountNumber = accountNumber;
		this.typeOfBank = typeOfBank;
	}
	
}
