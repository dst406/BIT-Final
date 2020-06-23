package com.varchar.www.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varchar.www.model.dao.ApprovalDAO;
import com.varchar.www.model.domain.approval.ApprovalVO;
import com.varchar.www.model.service.ApprovalService;

@Service
public class ApprovalServiceImpl implements ApprovalService {
	
	@Autowired
	private ApprovalDAO approvaldao;

	@Override
	public List<ApprovalVO> getApprovalList() {
		return approvaldao.getApprovalList();
	}


	@Override
	public List<ApprovalVO> getMyApprovalList(String userId) {
		return approvaldao.getMyApprovalList(userId);
	}


	@Override
	public List<ApprovalVO> getApprovalType(String approvalType) {
		if(approvalType.equals("전체")) return approvaldao.getApprovalList();
		else return approvaldao.getApprovalType(approvalType);
	}


	@Override
	public void updateApprovalAllow(String approvalNo) {
		approvaldao.updateApprovalAllow(approvalNo);
		
	}


	@Override
	public void updateApprovalReject(String approvalNo) {
		approvaldao.updateApprovalReject(approvalNo);
		
	}
	
	

}
