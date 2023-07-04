package com.masai.dto;

import java.time.LocalDate;

import com.masai.bean.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentAdressDto {

	private Integer studentId;
	private LocalDate dob;
	private Address address;
	
	
}
