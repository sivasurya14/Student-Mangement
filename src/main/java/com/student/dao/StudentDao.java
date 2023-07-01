package com.student.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.entity.Student;
import com.student.exceptionhandler.AgeNotEligibleException;
import com.student.repo.StudentRepository;

@Repository
public class StudentDao {

	@Autowired
	StudentRepository studentRepo;

	public String saveStudentDetails(Student student) throws AgeNotEligibleException, Exception {
		studentRepo.save(student);
		return "Data Saved Successfully";

	}

	public String saveStudentsDetails(List<Student> student) throws AgeNotEligibleException, Exception {
		studentRepo.saveAll(student);
		return "Data Saved Successfully";
	}
  
	public List<Student> getStudentsDetails(){
		return studentRepo.findAll();
	}
	
	public String deleteStudentByID(int id){
		studentRepo.deleteById(id);
		return "Data Deleted Successfully";
	}
	
	public String updateStudentById(Student student) {		
		studentRepo.save(student);
		return "Data Updated Successfully";
	}
	
	public List<Student> getName(int rollno) {
		return studentRepo.getName(rollno);
	}
	
}