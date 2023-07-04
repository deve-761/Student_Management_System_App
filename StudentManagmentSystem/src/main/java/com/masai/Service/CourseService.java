package com.masai.Service;

import java.util.List;

import com.masai.Exception.CourseException;
import com.masai.Exception.StudentException;
import com.masai.dto.CourseDto;
import com.masai.dto.CourseStudentsDto;
import com.masai.dto.StudentCourseDto;

public interface CourseService {

	public CourseDto addCourse(CourseDto courseDTO) throws CourseException;
	
	public StudentCourseDto assignCourseToStudent(Integer studentId,Integer courseId) throws CourseException, StudentException;
	
	public CourseStudentsDto getStudentsFromCourse(Integer courseId) throws CourseException;
	
	public List<CourseDto> getCoursesByTopic(String topicName) throws CourseException;
	
	public CourseDto removeCourse(Integer courseId) throws CourseException;
	
	
}