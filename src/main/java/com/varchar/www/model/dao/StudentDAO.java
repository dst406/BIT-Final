package com.varchar.www.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.varchar.www.model.domain.page.Criteria;
import com.varchar.www.model.domain.student.Student;

@Mapper
public interface StudentDAO {

	List<Student> getStudentList(@Param("cri") Criteria cri, @Param("authorityCode") String authorityCode);
	void insertStudent(Student student);
	Student getStudentInfo(String userId);
	void modifyStudent(Student student);
	void deleteStudent(String userId);
	int getStudentAccount(String authorityCode);
}
