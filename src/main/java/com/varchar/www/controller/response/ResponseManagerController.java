package com.varchar.www.controller.response;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.varchar.www.model.domain.approval.ApprovalVO;
import com.varchar.www.model.domain.manager.Attendance;
import com.varchar.www.model.service.ApprovalService;
import com.varchar.www.model.service.TeacherService;

@RestController
@RequestMapping("/manager")
public class ResponseManagerController {
	
	@Autowired
	private ApprovalService approvalService;
	
	@Autowired
	private TeacherService teacherService;
	
	@GetMapping("/approval/search")
	public List<ApprovalVO> getApprovalListByType(String approvalType){
		System.err.println(approvalType);
		return approvalService.getApprovalType(approvalType);
		
	}
	
	@GetMapping("/attendance/search")
	public List<Attendance> getAttendanceListByType(String attendanceStateName){
		System.err.println();
		return teacherService.getAttendanceType(attendanceStateName);
	}
	
	

}
