package com.masai.ServiceIMPL;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.CourseException;
import com.masai.Exception.StudentException;
import com.masai.Repositry.CourseRepo;
import com.masai.Service.CourseService;
import com.masai.Service.StudentService;
import com.masai.bean.Course;
import com.masai.bean.Student;
import com.masai.dto.CourseDto;
import com.masai.dto.CourseStudentsDto;
import com.masai.dto.StudentCourseDto;
import com.masai.dto.StudentDto;



@Service
public class CourseServiceIMPL implements CourseService{
	
	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private StudentService studentService;
	
	
	
	public Course dtoToCourse(CourseDto courseDTO) {
		return this.modelMapper.map(courseDTO, Course.class);
	}
	
	public CourseDto courseToDTO(Course course) {
		return this.modelMapper.map(course, CourseDto.class);
	}
	
	public StudentDto studentToDTO(Student student) {
		return this.modelMapper.map(student, StudentDto.class);
	}
	
	

	@Override
	public CourseDto addCourse(CourseDto courseDTO) throws CourseException {
		
		
		Course course = dtoToCourse(courseDTO);
		course = courseRepo.save(course) ;
		
		return courseToDTO(course);
	}

	@Override
	public StudentCourseDto assignCourseToStudent(Integer studentId, Integer courseId)
			throws CourseException, StudentException {
		
		
		
		Course course =  courseRepo.findById(courseId).orElseThrow(()-> new CourseException("Invalid CourseId "+ courseId)) ;
		Student student = studentService.getStudentById(studentId);
				
		course.getStudents().add(student);
		Course updatedCourseDetails = courseRepo.save(course);
		
		List<Course> studentCourses =  studentService.getAllCourses(studentId);
		
		StudentCourseDto studentCourseDetails = studentService.coursesToStudentCourse(studentCourses, student);
		
		return studentCourseDetails;
		
		
	}

	@Override
	public CourseStudentsDto getStudentsFromCourse(Integer courseId) throws CourseException {
		
		
        Course course =  courseRepo.findById(courseId).orElseThrow(()-> new CourseException("Invalid CourseId "+ courseId)) ;
		
		if(course.getStudents().isEmpty()) 
			throw new CourseException("No students are present in the Course: " + course.getCourseName()) ;
		
		List<Student> students = course.getStudents();
		List<StudentDto> studentDTOs = students.stream()
				.map(student -> this.studentToDTO(student)).collect(Collectors.toList()) ;
		
		CourseStudentsDto courseStudents = new CourseStudentsDto();
		BeanUtils.copyProperties(course, courseStudents);
		courseStudents.setStudentList(studentDTOs);
		
		return courseStudents;
		
		
	}

	@Override
	public List<CourseDto> getCoursesByTopic(String topicName) throws CourseException {
		
		List<Course> courses = courseRepo.getCoursesByTopic(topicName);
		List<CourseDto> dtoList = new ArrayList<>();
		
		dtoList =  courses.stream().map(course -> courseToDTO(course)).collect(Collectors.toList()) ;
 		return dtoList;
		
		
	}

	@Override
	public CourseDto removeCourse(Integer courseId) throws CourseException {
		
        Course course =  courseRepo.findById(courseId).orElseThrow(()-> new CourseException("Invalid CourseId: "+courseId)) ;
		
		courseRepo.delete(course);
		
		return courseToDTO(course);
		
		
	}

}
