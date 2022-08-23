 package com.pensionmanagement.pensionerdetails.feing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.pensionmanagement.pensionerdetails.models.ValidityResponse;

@Component
@FeignClient(name="authorization",url = "localhost:8080")
public interface AuthenticationProxy {
	@GetMapping("/validateToken")
	public ValidityResponse getValidity(@RequestHeader("Authorization") final String token);
}
