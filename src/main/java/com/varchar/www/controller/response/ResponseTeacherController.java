package com.varchar.www.controller.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.varchar.www.model.domain.teacher.TeacherVO;
import com.varchar.www.model.service.ManagerService;

@RestController
@RequestMapping("/teacher")
public class ResponseTeacherController {

	@Autowired private ManagerService managerService;
	
	/*
	 * //원장이 일자별로 출석상태를 검색
	 * 
	 * @GetMapping("/timeCard/dateSearch") public List<Attendance>
	 * getTeacherTimeCardByDate(String attendanceGoTime){
	 * System.err.println(attendanceGoTime); List<Attendance> lists =
	 * teacherService.getTeacherTimeCardByDate(attendanceGoTime);
	 * System.err.println(lists); return lists; }
	 */
	
	//강사가 본인 이미지를 업로드
	@PostMapping("/image/upload")
	public void putTeacherImage(MultipartFile imgFile) {
		managerService.uploadManagerImage(imgFile);
	}
	
	//강사의 본인정보 수정
	@PutMapping("/update")
	public void updateTeacherInfo(@RequestBody TeacherVO manager) {
		System.err.println(manager);
		managerService.updateManagerInfo(manager);
	}
	

}
