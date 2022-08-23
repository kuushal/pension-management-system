package com.pensionmanagement.authorization.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="users",uniqueConstraints = { @UniqueConstraint(columnNames = "username") })
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max = 15)
	private String username;
	@NotBlank
	@Size(max = 100)
	private String password;

	public UserModel(String username, String password) {
		this.username = username;
		this.password = password;
	}

}
