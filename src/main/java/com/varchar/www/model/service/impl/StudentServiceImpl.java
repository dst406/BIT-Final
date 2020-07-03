package com.varchar.www.model.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.varchar.www.model.dao.StudentDAO;
import com.varchar.www.model.domain.lecture.Lecture;
import com.varchar.www.model.domain.page.Criteria;
import com.varchar.www.model.domain.student.Payment;
import com.varchar.www.model.domain.student.Student;
import com.varchar.www.model.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	
	@Autowired
	private StudentDAO studentDAO;
	

	private static final String uploadDirectory = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img\\";
	
	@Override
	public List<Student> getStudentList(Criteria cri, String authorityCode) {

		return studentDAO.getStudentList(cri, authorityCode);
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

	@Override
	public void uploadStudentImage(MultipartFile imgFile) {
		System.err.println(imgFile);
		System.err.println(uploadDirectory);
		File file = new File(uploadDirectory);
		
		if (file.exists() == false) {
			file.mkdirs();
		}
		
		try {
			File save = new File(uploadDirectory + imgFile.getOriginalFilename());
			imgFile.transferTo(save);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int getStudentAccount(String authorityCode) {
		// TODO Auto-generated method stub
		return studentDAO.getStudentAccount(authorityCode);
	}
	
	public void insertLectureForPayment(Payment payment) {
			studentDAO.insertLectureForPayment(payment);
		
	}

	@Override
	public List<Lecture> getStudentLectureList() {
		return studentDAO.getStudentLectureList();
	}

	@Override
	public List<Lecture> getStudentMyLectureList() {
		return studentDAO.getStudentMyLectureList();
	}

}
