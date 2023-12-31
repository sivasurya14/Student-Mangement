package com.student.service;

import java.util.List;

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

		for (Student stu : student) {
			if (stu.getAge() < 18) {
				throw new AgeNotEligibleException(stu.getId() + " age is  below 18.!");
			} else {
				continue;
			}
		}
		return studentDao.saveStudentsDetails(student);

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
