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
	public List<Student> getStudentList(String authority_code) {
		// TODO Auto-generated method stub
		return studentDAO.getStudentList(authority_code);
	}

	@Override
	public void insertStudent(Student student) {
		// TODO Auto-generated method stub
		studentDAO.insertStudent(student);
	}

	@Override
	public Student getStudentInfo(String user_id) {
		// TODO Auto-generated method stub
		return studentDAO.getStudentInfo(user_id);
	}

	@Override
	public void modifyStudent(Student student) {
		// TODO Auto-generated method stub
		System.out.println(student);
		studentDAO.modifyStudent(student);
	}

}
