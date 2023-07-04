package com.masai.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

	
private Integer courseId;
	
	@NotNull(message = "courseName cannot be Null")
	@NotBlank(message = "courseName cannot be blank")
	@NotEmpty(message = "courseName cannot be empty")
	@Size(min = 3,max = 30,message = "courseName size should be of 3-30")
	private String courseName;
	
	@NotNull(message = "description cannot be Null")
	@NotBlank(message = "description cannot be blank")
	@NotEmpty(message = "description cannot be empty")
	@Size(min = 5,max = 225,message = "description size should be of 5-225")
	private String description;
	
	@NotNull(message = "description cannot be Null")
	@NotBlank(message = "description cannot be blank")
	@NotEmpty(message = "description cannot be empty")
	private String courseType;
	
	@NotNull(message = "description cannot be Null")
	@NotBlank(message = "description cannot be blank")
	@NotEmpty(message = "description cannot be empty")
	private String duration;
	
	@NotNull(message = "description cannot be Null")
	@NotBlank(message = "description cannot be blank")
	@NotEmpty(message = "description cannot be empty")
	@Size(min = 5,max = 200,message = "topics size should be of 5-200")
	private String topics;
	
	
}
