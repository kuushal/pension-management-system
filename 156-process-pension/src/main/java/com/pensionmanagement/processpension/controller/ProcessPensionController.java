package com.pensionmanagement.processpension.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.pensionmanagement.processpension.feing.AuthenticationProxy;
import com.pensionmanagement.processpension.feing.PensionerDetailsProxy;
import com.pensionmanagement.processpension.model.PensionDetails;
import com.pensionmanagement.processpension.model.ProcessPensionInput;
import com.pensionmanagement.processpension.repository.PensionerDetailsRepository;
import com.pensionmanagement.processpension.service.ProcessPensionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class ProcessPensionController {
	
	@Autowired
	private AuthenticationProxy authenticationProxy;
	
	@Autowired
	private PensionerDetailsProxy pensionerDetailsProxy;
	
	@Autowired
	private ProcessPensionService processPensionService;
	 
	@Autowired
	private PensionerDetailsRepository detailsRepository;
	
	
	@PostMapping("ProcessPension")
	public PensionDetails completeProcessing(@RequestHeader("Authorization") String token,@RequestBody ProcessPensionInput input) throws Exception{
		authenticationProxy.getValidity(token);
		
		ProcessPensionInput details=pensionerDetailsProxy.findByAadhaarNumber(token, input.getAadhaarNumber());
		
		if(details==null) {
			log.warn("Aadhaar number is invalid");
		}else {
			
			System.out.println("Fetching details....");
			System.out.println(details.getAccountNumber()+ " "+details.getTypeOfBank());
			double bankServiceCharge=processPensionService.bankServiceCharge(details);
			
			double pensionAmount=processPensionService.pensionAmount(details);
			
			PensionDetails pensionDetails=new PensionDetails(input.getAadhaarNumber(), pensionAmount, bankServiceCharge);
			
			detailsRepository.save(pensionDetails);
			log.info("Request is processed successfully.");
			return pensionDetails;
		}
		
		return null;
	}
	
	@GetMapping("/health-check")
	public ResponseEntity<String> healthCheck() {
		return new ResponseEntity<>("Process pension working..", HttpStatus.OK);
	}

	

}
