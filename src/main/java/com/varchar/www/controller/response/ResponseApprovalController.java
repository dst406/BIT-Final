package com.varchar.www.controller.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.varchar.www.model.service.ApprovalService;

@RestController
public class ResponseApprovalController {
	
	@Autowired
	private ApprovalService approvalService;
	
	//원장이 결재의 승인버튼 클릭
	@GetMapping("/manager/approval/allow/{approvalCode}")
	public void updateApprovalAllow(@PathVariable String approvalCode) {
		System.out.println(approvalCode);
		approvalService.updateApprovalAllow(approvalCode);
	}
	
	//원장이 결재의 반려버튼 클릭
	@PutMapping("/manager/approval/reject")
	public void updateApprovalReject(@RequestBody String approvalCode) {
		approvalService.updateApprovalReject(approvalCode);
	}

}
