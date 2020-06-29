package com.varchar.www.model.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.varchar.www.model.domain.page.Criteria;
import com.varchar.www.model.domain.student.Payment;
import com.varchar.www.model.domain.student.Student;

public interface StudentService {
	List<Student> getStudentList(Criteria cri, String authorityCode);
	Student getStudentInfo(String userId);
	void insertStudent(Student student);
	void modifyStudent(Student student);
	void deleteStudent(String userId);
	void uploadStudentImage(MultipartFile imgFile);
	
	// 학생이 강의 결제
		void insertLectureForPayment(Payment payment);
	
}
