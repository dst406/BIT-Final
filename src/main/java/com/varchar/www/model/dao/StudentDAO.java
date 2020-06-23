package com.varchar.www.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.varchar.www.model.domain.student.Student;

@Mapper
public interface StudentDAO {

	List<Student> getStudentList(String authority_code);
	void insertStudent(Student student);
	Student getStudentInfo(String user_id);
	void modifyStudent(Student student);
	void deleteStudent(String user_id);
}
