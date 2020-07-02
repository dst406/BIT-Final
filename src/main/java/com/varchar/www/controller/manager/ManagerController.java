package com.varchar.www.controller.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.varchar.www.model.domain.page.Criteria;
import com.varchar.www.model.service.ApprovalService;
import com.varchar.www.model.service.LectureService;
import com.varchar.www.model.service.ManagerService;


@Controller
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	
	@Autowired private ApprovalService approvalService;
	@Autowired private LectureService lectureService;
	
	
	//원장의 메인페이지
	@GetMapping("/manager/managerIndex")
	public String managerIndex(Criteria cri, Model model) {
		model.addAttribute("lectureList", lectureService.getLectureListNoFull());
		model.addAttribute("approvalList", approvalService.getApprovalType(cri, "결재대기"));
		return"main/managerIndex";
	}
	
	//원장이 자신의 정보를 조회하는 페이지
	@GetMapping("/manager/getManagerInfo")
	public String getManagerInfo(Model model) {
		model.addAttribute("manager", managerService.getManagerInfo("1"));
		model.addAttribute("getManagerCareer", managerService.getManagerCareer("kojae1234"));
		return"manager/getManagerInfo";
	}
	
	
	
}
