package com.varchar.www.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varchar.www.model.dao.StudentDAO;
import com.varchar.www.model.domain.student.Student;
import com.varchar.www.model.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	public List<Student> getStudentList(String authorityCode) {

		return studentDAO.getStudentList(authorityCode);
	}

	@Override
	public void insertStudent(Student student) {

		studentDAO.insertStudent(student);
	}

	@Override
	public Student getStudentInfo(String userId) {

		return studentDAO.getStudentInfo(userId);
	}

	@Override
	public void modifyStudent(Student student) {

		studentDAO.modifyStudent(student);
	}

	@Override
	public void deleteStudent(String userId) {

		studentDAO.deleteStudent(userId);
	}

}
