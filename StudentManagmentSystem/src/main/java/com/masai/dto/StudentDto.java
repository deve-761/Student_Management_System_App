package com.masai.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.Address;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StudentDto {

    private Integer studentId;
	
	@NotNull(message = "name cannot be Null")
	@NotBlank(message = "name cannot be blank")
	@NotEmpty(message = "name cannot be empty")
	private String name;
	
	@NotNull(message = "parentName cannot be Null")
	@NotBlank(message = "parentName cannot be blank")
	@NotEmpty(message = "parentName cannot be empty")
	private String parentName;
	
	@Email(message = "Please enter valid emailId")
	private String email;
	
	@Pattern(regexp = "[6-9][0-9]{9}",message = "Mobile number should start with 6-9 and of size 10")
	private String mobileNumber;
	
	private LocalDate dob;
	
	@NotNull(message = "gender cannot be Null")
	private String gender;
	
	
	private List<Address> address = new ArrayList<>();
	
	
}
