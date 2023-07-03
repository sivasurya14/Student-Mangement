package com.student.service;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.StudentDao;
import com.student.entity.Student;
import com.student.exceptionhandler.AgeNotEligibleException;

@Service
public class StudentService {

	@Autowired
	StudentDao studentDao;

	public String saveStudentDetails(Student student) throws AgeNotEligibleException, Exception {
		
		if (student.getAge() < 18) {
			throw new AgeNotEligibleException("Age should not be below 18.!");
		} else {
			return studentDao.saveStudentDetails(student);
		}
	}

	public String saveStudenstDetails(List<Student> student) throws AgeNotEligibleException, Exception {
		List<Student> savedObjects = student.stream().filter(x->x.getAge()>18).collect(Collectors.toList());
		List<Student> lessthan18= student.stream().filter(x->x.getAge()<18).collect(Collectors.toList());
				studentDao.saveStudentsDetails(savedObjects);
				if(!lessthan18.isEmpty()) {
					for(Student les :lessthan18) {
						throw new AgeNotEligibleException(les.getName()+" data is not saved in database. age should not below 18");
					}
				}
			 return "Data Saved Successfully";
}

	public List<Student> getStudentDetails() {
		return studentDao.getStudentsDetails();
	}

	public String deleteStudentById(int id) {
		return studentDao.deleteStudentByID(id);
	}

	public String updateStudentById(Student student) {
		return studentDao.updateStudentById(student);
	}

	public List<Student> getNameByRollNo(int id) {
		return studentDao.getName(id);
	}
}
