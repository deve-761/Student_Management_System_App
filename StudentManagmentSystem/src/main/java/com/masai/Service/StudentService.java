package com.masai.Service;

import java.util.List;

import com.masai.Exception.CourseException;
import com.masai.Exception.StudentException;
import com.masai.Exception.UserException;
import com.masai.bean.Course;
import com.masai.bean.Student;
import com.masai.dto.StudentAdressDto;
import com.masai.dto.StudentCourseDto;
import com.masai.dto.StudentDto;
import com.masai.dto.StudentUpdateDto;

public interface StudentService {

	
public StudentDto registerStudent(StudentDto studentDTO) throws StudentException, UserException;
	
	public Student getStudentById(Integer studentId) throws StudentException ;
	
	public List<Course> getAllCourses(Integer studentId) throws StudentException ;
	
	public List<StudentDto> getStudentByName(String name) throws StudentException;
	
	public StudentDto updateEmailAndMobile(StudentUpdateDto dto) throws StudentException;
	
	public StudentDto updateStudentAddress(StudentAdressDto addressDTO) throws StudentException;
	
	public StudentCourseDto getStudentCourses(Integer studentId,String dateOfBirth) throws StudentException;
	
	public StudentCourseDto leaveCourse(Integer studentId,String dateOfBirth,Integer courseId) throws StudentException, CourseException;
	
	public StudentCourseDto coursesToStudentCourse(List<Course> courses,Student student) ;
	
	public StudentDto addNewAddress(StudentAdressDto addressDTO) throws StudentException;
	
	
	
	
	
	
}
