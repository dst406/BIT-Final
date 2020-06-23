package com.varchar.www.controller.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.varchar.www.model.service.ManagerService;


@Controller
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	
	
	//원장의 메인화면입니다.
	@GetMapping("/managerIndex")
	public String managerIndex() {
		return"main/managerIndex";
	}
	
	//원장이 자신의 정보를 조회 
	@GetMapping("/getManagerInfo/{authorityCode}")
	public String getManagerInfo(Model model, @PathVariable String authorityCode, String userId) {
		model.addAttribute("manager",managerService.getManagerInfo("1"));
		model.addAttribute("getManagerCareer", managerService.getManagerCareer("kojae2020"));
		return"manager/getManagerInfo";
	}
	
	
	
}
