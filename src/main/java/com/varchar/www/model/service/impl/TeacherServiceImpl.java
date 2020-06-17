package com.varchar.www.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varchar.www.model.dao.TeacherDAO;
import com.varchar.www.model.domain.student.Student;
import com.varchar.www.model.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherDAO teacherDAO;


	

}
