package com.varchar.www.controller.response;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.varchar.www.model.domain.manager.Attendance;
import com.varchar.www.model.service.TeacherService;

@RestController
public class ResponseTeacherController {
	
	@Autowired private TeacherService teacherService;
	
	@GetMapping("/teacher/timeCard/dateSearch")
	public List<Attendance> getTeacherTimeCardByDate(String attendanceGoTime){
		System.err.println(attendanceGoTime);
		List<Attendance> lists = teacherService.getTeacherTimeCardByDate(attendanceGoTime);
		System.err.println(lists);
		return lists;
	}
}
