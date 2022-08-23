package com.pensionmanagement.pensionerdetails.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pensionmanagement.pensionerdetails.exceptions.ResourceNotFoundException;
import com.pensionmanagement.pensionerdetails.models.BankDetails;
import com.pensionmanagement.pensionerdetails.models.PensionerDetails;
import com.pensionmanagement.pensionerdetails.repository.PensionerDetailsRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PensionerDetailsServiceImpl implements PensionerDetailsService {

	@Autowired
	private PensionerDetailsRepository pensionerDetailsRepository;

	@Override
	public void loadPensionerDetails() {
		List<PensionerDetails> pensionerDetailsList = new ArrayList<>();

		try {
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/pensionerDetails.csv"));
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				PensionerDetails pensionerDetails = new PensionerDetails();
				pensionerDetails.setAadhaarNumber(values[0]);
				pensionerDetails.setName(values[1]);
				pensionerDetails.setDateOfBirth(values[2]);
				pensionerDetails.setPanNumber(values[3]);
				pensionerDetails.setSalary(Double.parseDouble(values[4]));
				pensionerDetails.setAllowance(Double.parseDouble(values[5]));
				pensionerDetails.setPensionType(values[6]);
				pensionerDetails.setBankName(values[7]);
				pensionerDetails.setAccountNumber(values[8]);
				pensionerDetails.setTypeOfBank(values[9]);
				pensionerDetailsList.add(pensionerDetails);
			}
			br.close();
		} catch (IOException e) {
			log.warn(e.getMessage());
			throw new ResourceNotFoundException("Pensioner details were not added.");
		}
		pensionerDetailsRepository.saveAll(pensionerDetailsList);
		log.info("Pensioner details data saved successfully.");

	}

	@Override
	public PensionerDetails getPensionerDetails(String aadharNumber) {
		PensionerDetails pensionerDetails = pensionerDetailsRepository.findById(aadharNumber).orElseThrow(()-> new ResourceNotFoundException("Details not found with the aadhaar number"));
		return pensionerDetails;
		
	}

}
