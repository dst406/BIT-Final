package com.varchar.www.controller.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.varchar.www.model.service.ManagerService;

@Controller
public class TeacherController {
	
	@Autowired
	private ManagerService managerService;
	
	//강사의 메인페이지 입니다.
	@GetMapping("/teacherIndex")
	public String teacherIndex() {
		return "/main/teacherIndex";
	}
	//강사목록
	@GetMapping("/getTeacherList")
	public String getTeacherList(Model model) {
		model.addAttribute("teacherList", managerService.getTeacherList("2"));
		model.addAttribute("managerList", managerService.getTeacherList("1"));
		return "/teacher/getTeacherList";
	}
}