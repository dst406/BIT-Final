package com.varchar.www.controller.approval;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.varchar.www.model.service.ApprovalService;

@Controller
public class ApprovalController {
	
	@Autowired
	private ApprovalService approvalService;
	
	//원장이 조회하는 결재목록
	@GetMapping("/getManagerApprovalList")
	public String getManagerApprovalList(Model model) {
		model.addAttribute("approvalList", approvalService.getApprovalList());
		return "approval/getManagerApprovalList";
	}
    //강사가 조회하는 결재목록
    @GetMapping("/getTeacherApprovalList/{userId}")
	public String getTeacherApprovalList(Model model,@PathVariable String userId) {
    	model.addAttribute("approvalList",approvalService.getMyApprovalList(userId));
		return "approval/getTeacherApprovalList";
	}
    
    //강사의 결재신청 페이지
    @GetMapping("/insertApproval")
    public String insertApproval() {
    	return "approval/insertApproval";
    }
    
    //강사의 결재신청
    @PostMapping("/goInsertApproval")
    public String goInsertApproval() {
    	return "redirect:/approval/getTeacherApprovalList";
    }
    
    
}
