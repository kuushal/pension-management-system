package com.pensionmanagement.pensionerdetails.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "bank_details")
public class BankDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String accountNumber;
	private String bankName;
	private String typeOfBank;

	public BankDetails(String bankName, String accountNumber, String typeOfBank) {
		super();
		this.bankName = bankName;
		this.accountNumber = accountNumber;
		this.typeOfBank = typeOfBank;
	}
}
