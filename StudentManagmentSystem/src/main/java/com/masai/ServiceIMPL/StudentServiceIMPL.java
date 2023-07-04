package com.masai.ServiceIMPL;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

 
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.CourseException;
import com.masai.Exception.StudentException;
import com.masai.Exception.UserException;
import com.masai.Repositry.AddressRepo;
import com.masai.Repositry.CourseRepo;
import com.masai.Repositry.StudentRepo;
import com.masai.Service.StudentService;
import com.masai.Service.UserService;
import com.masai.bean.Address;
import com.masai.bean.Course;
import com.masai.bean.Student;
import com.masai.dto.CourseDto;
import com.masai.dto.StudentAdressDto;
import com.masai.dto.StudentCourseDto;
import com.masai.dto.StudentDto;
import com.masai.dto.StudentUpdateDto;


@Service
public class StudentServiceIMPL implements StudentService{
	
	
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AddressRepo addressRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CourseRepo courseRepo;
	
	
	
	
	
	public Student dtoToStudent(StudentDto studentDTO) {
		return this.modelMapper.map(studentDTO, Student.class);
	}
	
	public StudentDto studentToDTO(Student student) {
		return this.modelMapper.map(student, StudentDto.class);
	}
	
	
	
	
	public Student validateStudentIdAndDOB(Integer studentId,LocalDate dob) {
			
			Optional<Student> studentOpt = studentRepo.findById(studentId);
			
			if(studentOpt.isEmpty()) 
				return null;
			
			Student student = studentOpt.get();
			
			if(!dob.equals(student.getDob())) 
				return null;
			
			return student;
		}
		

	@Override
	public StudentDto registerStudent(StudentDto studentDTO) throws StudentException, UserException {
        Student student = dtoToStudent(studentDTO);
		
		student = studentRepo.save(student) ;		
			
		return studentToDTO(student);
	}

	@Override
	public Student getStudentById(Integer studentId) throws StudentException {
		
		
		return studentRepo.findById(studentId).orElseThrow(() -> new StudentException("Invalid StudentId "+ studentId));
		
		
	}

	@Override
	public List<Course> getAllCourses(Integer studentId) throws StudentException {
		
		
		return studentRepo.findById(studentId).orElseThrow(() -> new StudentException("Invalid StudentId "+ studentId)).getCourses();
		
		
		
	}

	@Override
	public List<StudentDto> getStudentByName(String name) throws StudentException {
		
		
        List<Student> students = studentRepo.getStudentsByName(name);
		
		if(students.isEmpty()) 
			throw new StudentException("No student found with name : "+name) ;

		List<StudentDto> studentsDTO =  students
										.stream()
										.map(student -> this.studentToDTO(student)).collect(Collectors.toList()) ;

		return studentsDTO;
		
		
	}



	@Override
	public StudentDto updateEmailAndMobile(StudentUpdateDto dto) throws StudentException {
       Student student = validateStudentIdAndDOB(dto.getStudentId(), dto.getDob());
		
		if(student  == null) 
			throw new StudentException("Invalid StudentId Or DOB!") ;
		
		student.setMobileNumber(dto.getNewMobileNumber());
		student.setEmail(dto.getNewEmail());
		
		student = studentRepo.save(student) ;
		
		return studentToDTO(student);
	}

	@Override
	public StudentDto updateStudentAddress(StudentAdressDto addressDTO) throws StudentException {
        Student student =  validateStudentIdAndDOB(addressDTO.getStudentId(), addressDTO.getDob());
		
		List<Address> addressList =  student.getAddress();
		
		for(Address address : addressList) {
			if(address.getAddressId().equals(addressDTO.getAddress().getAddressId())) {
				addressRepo.save(addressDTO.getAddress()) ;
			}
		}
		
		Student updatedStudent = studentRepo.findById(student.getStudentId()).orElseThrow(() -> new StudentException("Invalid StudentId "+ student.getStudentId())) ;
		
		return studentToDTO(updatedStudent);
	}

	@Override
	public StudentCourseDto getStudentCourses(Integer studentId, String dateOfBirth) throws StudentException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate dob = LocalDate.parse(dateOfBirth, formatter);
				
		Student student = validateStudentIdAndDOB(studentId,dob) ;
		if(student == null) 
			throw new StudentException("Invalid student Id or Password") ;
		
	
		return coursesToStudentCourse(student.getCourses(), student);
	}

	@Override
	public StudentCourseDto leaveCourse(Integer studentId, String dateOfBirth, Integer courseId)
			throws StudentException, CourseException {
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate dob = LocalDate.parse(dateOfBirth, formatter);
				
		Student student = validateStudentIdAndDOB(studentId,dob) ;
		Course course = courseRepo.findById(courseId).orElseThrow(()-> new CourseException("Invalid courseId: "+courseId));
		
		
		if(student.getCourses().contains(course)) {
			student.getCourses().remove(course) ;
		}
		
		if(course.getStudents().contains(student)) {
			course.getStudents().remove(student) ;
		}
		courseRepo.save(course) ;
		
		student = studentRepo.save(student) ;
		
		return coursesToStudentCourse(student.getCourses(), student);
	}

	@Override
	public StudentCourseDto coursesToStudentCourse(List<Course> courses, Student student) {
		StudentCourseDto studentCourse = new StudentCourseDto();
		studentCourse.setStudentId(student.getStudentId());
		studentCourse.setName(student.getName());
		
		List<CourseDto> courseDTOList = new ArrayList<>();
		for(Course singleCourse : student.getCourses()) {
			
			CourseDto dto = new CourseDto();
			BeanUtils.copyProperties(singleCourse, dto);
			courseDTOList.add(dto) ;
		}
		
		studentCourse.setCourses(courseDTOList);
		
		return studentCourse;
	}

	@Override
	public StudentDto addNewAddress(StudentAdressDto addressDTO) throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

}
