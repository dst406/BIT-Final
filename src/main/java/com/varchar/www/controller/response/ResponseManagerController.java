package com.varchar.www.controller.response;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.varchar.www.model.domain.approval.ApprovalVO;
import com.varchar.www.model.domain.manager.Attendance;
import com.varchar.www.model.domain.page.Criteria;
import com.varchar.www.model.domain.teacher.TeacherVO;
import com.varchar.www.model.service.ApprovalService;
import com.varchar.www.model.service.ManagerService;
import com.varchar.www.model.service.TeacherService;

@RestController
@RequestMapping("/manager")
public class ResponseManagerController {
	
	@Autowired
	private ApprovalService approvalService;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private ManagerService managerService;
	
	//원장이 결재상태별로 드롭다운해서 보기
	@GetMapping("/approval/search/{userId}")
	public List<ApprovalVO> getApprovalListByType(@PathVariable String userId, Criteria cri, String approvalType){
		System.err.println(approvalType);
		return approvalService.getApprovalTeacherType(cri, approvalType, userId);
	}
	
	//원장이 강의상태별로 드롭다운해서 보기
	@GetMapping("/lecture/search/{userId}")
	public List<ApprovalVO> getLectureListByType(@PathVariable String userId, Criteria cri, String approvalType){
		System.err.println(approvalType);
		return null;
//		return approvalService.getlectureType(cri, approvalType, userId);
	}
		
	@GetMapping("/approval/search")
	public List<ApprovalVO> getApprovalListByType(Criteria cri, String approvalType){
		System.err.println(approvalType);
		return approvalService.getApprovalType(cri, approvalType);
	}
	
	/*
	 * @GetMapping("/attendance/search") public List<Attendance>
	 * getAttendanceListByType(String attendanceStateName, String attendanceGoTime){
	 * System.err.println(attendanceStateName); return
	 * teacherService.getAttendanceType(attendanceStateName, attendanceGoTime); }
	 */
	
	//원장이 본인 이미지를 업로드
	@PostMapping("/image/upload")
	public void putManagerImage(MultipartFile imgFile) {
		managerService.uploadManagerImage(imgFile);
	}
	
	//원장의 본인정보 수정
	@PutMapping("/update")
	public void updateManagerInfo(@RequestBody TeacherVO manager) {
		managerService.updateManagerInfo(manager);
	}

}
