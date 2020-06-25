package com.varchar.www.controller.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.varchar.www.model.service.TeacherService;


import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.varchar.www.model.domain.teacher.Teacher;
import com.varchar.www.model.service.ManagerService;
import com.varchar.www.model.service.TeacherService;

@Controller
public class TeacherController {
	
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private TeacherService teacherService;
	
	//강사의 메인페이지 입니다.
	@GetMapping("/teacherIndex")
	public String teacher() {
		return "main/teacherIndex";
	}
	
	//강사의 메인페이지 입니다.
	@GetMapping("/teacher/teacherIndex")
	public String teacherIndex() {
		return "teacher/teacherIndex";
	}
	
	
	//강사목록페이지 입니다.
	@GetMapping("/getTeacherList")
	public String getTeacherList(Model model) {
		model.addAttribute("teacherList", managerService.getTeacherList("2"));
		model.addAttribute("managerList", managerService.getTeacherList("1"));
		return "teacher/getTeacherList";
	}
	
	//원장이 강사를 등록하는 페이지 입니다.
	@GetMapping ("/goInsertTeacher")
	public String goInsertTeacher(@ModelAttribute Teacher teacher) {
		return "teacher/insertTeacher";
	}
		
	//원장이 강사를 등록
	@PostMapping("/insertTeacher")
	public String insertTeacher(Teacher teacher) {
		teacherService.insertTeacher(teacher);
		return "redirect:/getTeacherList";
	}
	
	//원장이 강사를 삭제
	@GetMapping("/deleteTeacher/{userId}")
	public String deleteTeacher(@PathVariable String userId) {
		teacherService.deleteTeacher(userId);
		return "redirect:/getTeacherList";
	}
	
	
	//원장이 강사의 상세정보를 조회하는 페이지 입니다.
	@GetMapping ("/getTeacherInfo/{userId}")
	public String getTeacherInfo(@PathVariable String userId, Model model) {
		model.addAttribute("teacherInfo",teacherService.getTeacherInfo(userId));
		model.addAttribute("careerList",teacherService.getTeacherCareer(userId));
		return "teacher/getTeacherInfo";
	}
	
	//원장이 보는 강사 출퇴근 기록부 입니다.
	@GetMapping("/getManagerTeacherTimeCard")
	public String getManagerTeacherTimeCard(Model model) {
		model.addAttribute("getTeacherTimeCard",teacherService.getManagerTeacherTimeCard("2"));
		return "manager/getManagerTeacherTimeCard";
	}
	
	//강사가 보는 자신의 출퇴근 기록부 페이지 입니다.
	@GetMapping("/getTeacherTimeCard")
	public String getTeacherTimeCard(String authorityCode, Model model) {
		model.addAttribute("getTeachertimeCard", teacherService.getTeacherTimeCard("2"));
		return "teacher/getTeacherTimeCard";
	}
	
	//teacherView Test
	@GetMapping("/teacherView")
	public String teacherView() {
		return"teacher/teacherView";
	}
	
	//teacherInfo Test
	@GetMapping("/teacherInfo")
	public String teacherInfo() {
		return"/teacher/teacherInfo";
	}
	
	//teacherInfo Test2
		@GetMapping("/teacherInfo2")
		public String teacherInfo2() {
			return"/teacher/teacherInfo2";
		}
		
	

		
}
