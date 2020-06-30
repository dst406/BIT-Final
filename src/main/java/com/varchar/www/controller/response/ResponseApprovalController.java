package com.varchar.www.controller.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.varchar.www.model.service.ApprovalService;

@RestController
@RequestMapping("/approval")
public class ResponseApprovalController {
	
	@Autowired
	private ApprovalService approvalService;
	
	//승인버튼 클릭시
	@PutMapping("/allow")
	public void updateApprovalAllow(@RequestBody String approvalCode) {
		approvalService.updateApprovalAllow(approvalCode);
	}
	
	//반려버튼 클릭시
	@PutMapping("/reject")
	public void updateApprovalReject(@RequestBody String approvalCode) {
		approvalService.updateApprovalReject(approvalCode);
	}

}
