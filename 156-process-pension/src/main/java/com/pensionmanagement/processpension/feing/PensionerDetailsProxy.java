package com.pensionmanagement.processpension.feing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.pensionmanagement.processpension.model.ProcessPensionInput;

@FeignClient(name = "pensioner-details", url = "localhost:8012")
public interface PensionerDetailsProxy {

	@GetMapping("/pensionerDetails/{aadhaarNumber}")
	public ProcessPensionInput findByAadhaarNumber(@RequestHeader("Authorization") String token,
			@PathVariable String aadhaarNumber);

}
