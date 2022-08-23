package com.pensionmanagement.pensionerdetails.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ValidityResponse {
	private String token;
	private boolean isValid;
}
