package com.varchar.www.controller.approval;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.varchar.www.login.AcademyUser;
import com.varchar.www.model.domain.approval.ApprovalVO;
import com.varchar.www.model.domain.page.Criteria;
import com.varchar.www.model.domain.page.PageDTO;
import com.varchar.www.model.service.ApprovalService;

@Controller
public class ApprovalController {
	
	@Autowired
	private ApprovalService approvalService;
	
	//원장이 조회하는 결재목록
	@GetMapping("/getManagerApprovalList")
	public String getManagerApprovalList(Criteria cri, Model model) {
		model.addAttribute("approvalList", approvalService.getApprovalList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, approvalService.getApprovalAccount()));
		return "approval/getManagerApprovalList";
	}
	
    //강사가 조회하는 결재목록
    @GetMapping("/getTeacherApprovalList/{userId}")
	public String getTeacherApprovalList(@ModelAttribute ApprovalVO approvalVO, Model model,@PathVariable String userId) {
    	model.addAttribute("approvalList",approvalService.getMyApprovalList(userId));
		return "approval/getTeacherApprovalList";
	}
    
    //강사의 결재신청 페이지
    @GetMapping("/goInsertApproval")
    public String goInsertApproval(@ModelAttribute ApprovalVO approvalVO) {
    	return "approval/insertApproval";
    }
    
    //강사의 결재신청
    @PostMapping("/insertApproval")
    public String insertApproval(ApprovalVO approvalVO,@AuthenticationPrincipal AcademyUser user) {
    	approvalVO.setUserId(user.getUserId());
    	approvalService.insertApproval(approvalVO);
    	return "redirect:/getTeacherApprovalList/" + user.getUserId();
    }
    
    
}
