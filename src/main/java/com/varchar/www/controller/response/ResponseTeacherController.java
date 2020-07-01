package com.varchar.www.controller.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.varchar.www.model.service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class ResponseTeacherController {
	
	@Autowired private TeacherService teacherService;
	
	/*
	 * //원장이 일자별로 출석상태를 검색
	 * 
	 * @GetMapping("/timeCard/dateSearch") public List<Attendance>
	 * getTeacherTimeCardByDate(String attendanceGoTime){
	 * System.err.println(attendanceGoTime); List<Attendance> lists =
	 * teacherService.getTeacherTimeCardByDate(attendanceGoTime);
	 * System.err.println(lists); return lists; }
	 */
	
	//원장이 강사등록시 이미지를 업로드
	@PostMapping("/image/upload")
	public void putManagerImage(MultipartFile imgFile) {
		teacherService.uploadTeacherImage(imgFile);
	}
	

}
