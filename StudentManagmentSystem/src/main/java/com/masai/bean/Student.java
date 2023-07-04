package com.masai.bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Student {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer studentId;
	private String name;
	private String parentName;
	

	private String email;
	private String mobileNumber;
	private LocalDate dob;
	private String gender;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> address = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "students")
	List<Course> courses = new ArrayList<>();

	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", parentName=" + parentName + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + ", dob=" + dob + ", gender=" + gender + "]";
	}
	
	
}
