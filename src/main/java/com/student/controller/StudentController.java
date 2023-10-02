package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.exceptionhandler.AgeNotEligibleException;
import com.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/saveStudentDetails")
	public String saveStudentDetails(@RequestBody Student student) throws AgeNotEligibleException, Exception {
		return studentService.saveStudentDetails(student);

	}
    @PostMapping("/saveStudentsDetails")
    
    public String saveStudentsDetails(@RequestBody List<Student> student) throws AgeNotEligibleException, Exception{
    	return studentService.saveStudenstDetails(student);
    }
	
    @GetMapping("/getStudentsDetails")  
    public List<Student>  getStudentsDetails(){
    	return studentService.getStudentDetails();
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable int id) {
    	return studentService.deleteStudentById(id);
    }
    
    
    @PutMapping("/update/{id}")
    public String updateStudentById(@PathVariable int id, @RequestBody Student student) {  	
    	return studentService.updateStudentById(student);
    }
    
    @GetMapping("/getDetailsRollNo/{rollno}")
    public List<Student> getNameByRollNo(@PathVariable int rollno) {
    	return studentService.getNameByRollNo(rollno);
    }
    
    //Added new Line
    
    //Added new Line 
}
