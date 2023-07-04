package com.masai.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;
	
	@NotNull(message = "area cannot be Null")
	@NotBlank(message = "area cannot be blank")
	@NotEmpty(message = "area cannot be empty")
	private String area;
	
	@NotNull(message = "city cannot be Null")
	@NotBlank(message = "city cannot be blank")
	@NotEmpty(message = "city cannot be empty")
	private String city;
	
	@NotNull(message = "state cannot be Null")
	@NotBlank(message = "state cannot be blank")
	@NotEmpty(message = "state cannot be empty")
	private String state;
	
	@NotNull(message = "district cannot be Null")
	@NotBlank(message = "district cannot be blank")
	@NotEmpty(message = "district cannot be empty")
	private String district;
	
	@NotNull(message = "pincode cannot be Null")
	@NotBlank(message = "pincode cannot be blank")
	@NotEmpty(message = "pincode cannot be empty")
	private String pincode;
	
	@NotNull(message = "addressType cannot be Null")
	private String addressType;
	
	
}
