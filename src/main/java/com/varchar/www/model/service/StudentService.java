package com.varchar.www.model.service;

import java.util.List;

import com.varchar.www.model.domain.student.Student;

public interface StudentService {
	List<Student> getStudentList(String authority_code);
	Student getStudentInfo(String user_id);
	void insertStudent(Student student);
	void modifyStudent(Student student);
}
