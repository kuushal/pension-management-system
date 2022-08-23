package com.pensionmanagement.pensionerdetails.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pensioner_details")
public class PensionerDetails {
	@Id
	@Column(name = "aadhar")
	private String aadhaarNumber;
	
	private String name;
	
	@Column(name = "dob")
	private String dateOfBirth;
	
	@Column(name = "pan")
	private String panNumber;
	
	private double salary;
	private double allowance;
	
	@Column(name = "pension")
	private String pensionType;
	
	@Column(name = "accnum")
	private String accountNumber;
	
	@Column(name = "bankname")
	private String bankName;
	
	@Column(name = "banktype")
	private String typeOfBank;
}
