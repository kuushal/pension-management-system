package com.pensionmanagement.processpension.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class PensionDetails {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String aadhaarNumber;
	private double pensionAmount;
	private double bankCharge;
	
	public PensionDetails(String aadharNumber, double pensionAmount, double bankCharge) {
		super();
		this.aadhaarNumber = aadharNumber;
		this.pensionAmount = pensionAmount;
		this.bankCharge = bankCharge;
	}
	
	
}

