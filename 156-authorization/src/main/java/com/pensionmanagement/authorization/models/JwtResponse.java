package com.pensionmanagement.authorization.models;

import java.io.Serializable;


public class JwtResponse implements Serializable {

	private static final long serialVersionUID = 2622479357214125757L;

	private String jwttoken;

	private boolean isValid;

	public JwtResponse() {
		super();
	}

	public JwtResponse(String jwttoken, boolean isValid) {
		this.jwttoken = jwttoken;
		this.isValid = isValid;
	}

	public String getToken() {
		return this.jwttoken;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
}
