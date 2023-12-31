package com.masai.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	private String name;
	private String mobileNumber;
	private String password;
	private String role;
	
	public User(String name, String mobileNumber, String password, String role) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.role = role;
	}

	public User(String name, String mobileNumber, String password) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.password = password;
	}
	
	
	
	
}
