package com.pensionmanagement.authorization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pensionmanagement.authorization.config.JwtTokenUtil;
import com.pensionmanagement.authorization.models.JwtResponse;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ValidationService {
	@Autowired
	private JwtTokenUtil jwttokenutil;

	public JwtResponse validate(String token) {
		JwtResponse response = new JwtResponse();
		String jwt = token.substring(7);
		if (jwttokenutil.validateToken(jwt)) {
			response.setValid(true);
			log.info("Token is validated successfully");
		} else {
			response.setValid(false);
			log.info("Token is not valid");
		}
		return response;
	}
}
