package com.pensionmanagement.authorization.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.pensionmanagement.authorization.models.JwtRequest;
import com.pensionmanagement.authorization.models.JwtResponse;
import com.pensionmanagement.authorization.service.LoginService;
import com.pensionmanagement.authorization.service.ValidationService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class JwtAuthenticationController {
	
	@Autowired
	private LoginService loginService;

	@Autowired
	private ValidationService validationService;

	@PostMapping(value = "/authenticate")
	public ResponseEntity<JwtResponse> generateAuthenticationToken(@RequestBody @Valid JwtRequest authenticationRequest)
			throws Exception {
		String token = loginService.checkLogin(authenticationRequest);
		log.trace("Token generated");
		return ResponseEntity.ok(new JwtResponse(token, true));
	}

	@GetMapping("/validateToken")
	public JwtResponse getValidity(@RequestHeader("Authorization") final String token) {
		log.trace("Validating the token");
		return validationService.validate(token);
	}

}
