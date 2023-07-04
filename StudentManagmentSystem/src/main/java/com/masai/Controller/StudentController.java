package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.CourseException;
import com.masai.Exception.StudentException;
import com.masai.Exception.UserException;
import com.masai.Service.StudentService;
import com.masai.dto.StudentAdressDto;
import com.masai.dto.StudentCourseDto;
import com.masai.dto.StudentDto;
import com.masai.dto.StudentUpdateDto;

import jakarta.validation.Valid;

@RestController
public class StudentController {

	
	@Autowired
	private StudentService studentService;

	
	@PostMapping("/students/")
	public ResponseEntity<StudentDto> registerStudentHandler(@Valid @RequestBody StudentDto studentDTO)
			throws StudentException, UserException {

		StudentDto registredStudent = studentService.registerStudent(studentDTO);

		return new ResponseEntity<StudentDto>(registredStudent, HttpStatus.CREATED);
	}

	
	@GetMapping("/students/")
	public ResponseEntity<List<StudentDto>> getStudentsByNameHandler(@RequestParam("name") String name)
			throws StudentException {

		List<StudentDto> studentsList = studentService.getStudentByName(name);

		return new ResponseEntity<List<StudentDto>>(studentsList, HttpStatus.OK);
	}

	@PatchMapping("/students/update/")
	public ResponseEntity<StudentDto> updateEmailAndMobileNumberHandler(@RequestBody StudentUpdateDto studentUpdateDTO)
			throws StudentException {

		StudentDto studentDTO = studentService.updateEmailAndMobile(studentUpdateDTO);

		return new ResponseEntity<StudentDto>(studentDTO, HttpStatus.OK);
	}

	@PatchMapping("/students/update/address")
	public ResponseEntity<StudentDto> updateAddressHandler(@Valid @RequestBody StudentAdressDto studentAddressDTO)
			throws StudentException {

		StudentDto studentDTO = studentService.updateStudentAddress(studentAddressDTO);

		return new ResponseEntity<StudentDto>(studentDTO, HttpStatus.OK);
	}

	@DeleteMapping("/students/courses")
	public ResponseEntity<StudentCourseDto> leaveCourseHandler(@RequestParam("studentId") Integer studentId,
															@RequestParam("dob,dd-MM-yyyy") String dateOfBirth, 
															@RequestParam("courseId") Integer courseId)
															throws StudentException, CourseException {

		StudentCourseDto studentCourse = studentService.leaveCourse(studentId, dateOfBirth, courseId);

		return new ResponseEntity<StudentCourseDto>(studentCourse, HttpStatus.OK);
	}

	@GetMapping("/students/courses")
	public ResponseEntity<StudentCourseDto> getStudentCoursesHandler(@RequestParam("studentId") Integer studentId,
																@RequestParam("dob,dd-MM-yyyy") String dateOfBirth) throws StudentException
																{

		StudentCourseDto studentCourse = studentService.getStudentCourses(studentId, dateOfBirth) ;

		return new ResponseEntity<StudentCourseDto>(studentCourse, HttpStatus.OK);
	}
	
	
	
	
}
