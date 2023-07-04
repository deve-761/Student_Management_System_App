package com.masai.Repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.bean.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

	@Query("from Student s where s.name LIKE %:name% ") 
	public List<Student> getStudentsByName(String name) ;
	
}