package com.varchar.www.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.varchar.www.model.domain.lecture.Lecture;
import com.varchar.www.model.domain.page.Criteria;
import com.varchar.www.model.domain.student.Payment;
import com.varchar.www.model.domain.student.Student;

@Mapper
public interface StudentDAO {

	List<Student> getStudentList(@Param("cri") Criteria cri, @Param("authorityCode") String authorityCode);
	void insertStudent(Student student);
	Student getStudentInfo(String userId);
	void modifyStudent(Student student);
	void deleteStudent(String userId);

	int getStudentAccount(String authorityCode);

	
	// 학생이 강의 결제
	void insertLectureForPayment(Payment payment);
	// !종료 인 강의리스트 	
	List<Lecture> getStudentLectureList();
	// 학생 : 내가 수강중인 강의
	List<Lecture> getStudentMyLectureList();
	
}
