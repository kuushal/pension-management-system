package com.pensionmanagement.pensionerdetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.pensionmanagement.pensionerdetails.feing.AuthenticationProxy;
import com.pensionmanagement.pensionerdetails.models.PensionerDetails;
import com.pensionmanagement.pensionerdetails.service.PensionerDetailsService;

@RestController
public class PensionDetailsController {

	@Autowired
	private PensionerDetailsService pensionerDetailsService;

	@Autowired
	private AuthenticationProxy authenticate;

	@GetMapping("/pensionerDetails/{aadhaarNumber}")
	public PensionerDetails findByAadhaarNumber(@RequestHeader("Authorization") String token,
			@PathVariable String aadhaarNumber) throws Exception {
		System.out.println("The token is: " + token);
		if (authenticate.getValidity(token).isValid()) {
			PensionerDetails pensionerDetails = pensionerDetailsService.getPensionerDetails(aadhaarNumber);
			return pensionerDetails;
		} else {
			throw new Exception("Token is not valid");
		}
	}

	@GetMapping("/health-check")
	public ResponseEntity<String> healthCheck() {
		return new ResponseEntity<>("Pensioner Details working..", HttpStatus.OK);
	}

}
