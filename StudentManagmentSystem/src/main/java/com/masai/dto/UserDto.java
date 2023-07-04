package com.masai.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

private Integer userId;
	
	@NotNull(message = "Name cannot be Null")
	@NotBlank(message = "Name cannot be blank")
	@NotEmpty(message = "Name cannot be empty")
	@Size(min = 2,max = 30,message = "name size should be of 2-30")
	private String name;
	
	@Pattern(regexp = "[6-9][0-9]{9}",message = "Mobile number should start with 6-9 and of size 10")
	private String mobileNumber;
	
	private String password;
	
	@NotNull(message = "role cannot be Null")
	@NotBlank(message = "role cannot be blank")
	@NotEmpty(message = "role cannot be empty")
	private String role;
	
	public UserDto(String name, String mobileNumber, String password) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.password = password;
	}
	
	
}
