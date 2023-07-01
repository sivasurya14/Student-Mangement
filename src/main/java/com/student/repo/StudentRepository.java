package com.student.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	@Query(value= "select * FROM student where roll_number=?",nativeQuery=true)
	public List<Student> getName(int rollno);

}
