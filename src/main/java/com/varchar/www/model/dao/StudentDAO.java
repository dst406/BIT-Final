package com.varchar.www.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.varchar.www.model.domain.page.Criteria;
import com.varchar.www.model.domain.student.Student;

@Mapper
public interface StudentDAO {

	List<Student> getStudentList(Criteria cri, String authorityCode);
	void insertStudent(Student student);
	Student getStudentInfo(String userId);
	void modifyStudent(Student student);
	void deleteStudent(String userId);
}
