package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.CourseException;
import com.masai.Service.CourseService;
import com.masai.dto.CourseDto;
import com.masai.dto.CourseStudentsDto;
import com.masai.dto.StudentCourseDto;

import jakarta.validation.Valid;

@RestController
public class CourseController {

	
	@Autowired(required = false)
	private CourseService courseService;
	
	
	@PostMapping("/courses/")
	public ResponseEntity<CourseDto> addCourseHandler(@Valid @RequestBody CourseDto courseDTO) throws CourseException {
		
		CourseDto savedCourse = courseService.addCourse(courseDTO);
		
		return new ResponseEntity<CourseDto>(savedCourse,HttpStatus.CREATED) ;
	}
	 

	@PutMapping("/courses/assgign")
	public ResponseEntity<StudentCourseDto> assginStudentToCourseHandler(@RequestParam("studentId") Integer sttudentId,
																	@RequestParam("courseId") Integer courseId) throws CourseException, StudentException {
		
		StudentCourseDto assignedCourse =  courseService.assignCourseToStudent(sttudentId, courseId) ;
		
		return new ResponseEntity<StudentCourseDto>(assignedCourse,HttpStatus.OK) ;
	}
	
	
	@GetMapping("/courses/")
	public ResponseEntity<CourseStudentsDto> getStudentsFromCorseHandler(@RequestParam Integer courseId) throws CourseException {
		
		CourseStudentsDto courseStudents =  courseService.getStudentsFromCourse(courseId);
		
		return new ResponseEntity<CourseStudentsDto>(courseStudents,HttpStatus.OK) ;
	}
	
	@DeleteMapping("/courses/")
	public ResponseEntity<CourseDto> removeCourseHandler(@RequestParam Integer courseId) throws CourseException {
		
		CourseDto removedCourse =  courseService.removeCourse(courseId);
		
		return new ResponseEntity<CourseDto>(removedCourse,HttpStatus.OK) ;
	}
	
	@GetMapping("/courses/topic")
	public ResponseEntity<List<CourseDto>> getCoursesByTopic(@RequestParam("topicName") String topicName) throws CourseException {
		
		List<CourseDto> courses =  courseService.getCoursesByTopic(topicName);
		
		return new ResponseEntity<List<CourseDto>>(courses,HttpStatus.OK);
	}
	
}
