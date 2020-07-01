package com.varchar.www.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varchar.www.model.dao.ApprovalDAO;
import com.varchar.www.model.domain.approval.ApprovalVO;
import com.varchar.www.model.domain.page.Criteria;
import com.varchar.www.model.service.ApprovalService;

@Service
public class ApprovalServiceImpl implements ApprovalService {

	@Autowired
	private ApprovalDAO approvaldao;

	@Override
	public List<ApprovalVO> getApprovalList(Criteria cri) {
		cri.setAmount(20);
		return approvaldao.getApprovalList(cri);
	}

	@Override
	public List<ApprovalVO> getMyApprovalList(String userId) {
		return approvaldao.getMyApprovalList(userId);
	}

	@Override
	public List<ApprovalVO> getApprovalType(Criteria cri, String approvalType) {
		cri.setAmount(20);
		if (approvalType.equals("전체"))
			return approvaldao.getApprovalList(cri);
		else
			return approvaldao.getApprovalType(cri, approvalType);
	}

	@Override
	public void updateApprovalAllow(String approvalNo) {
		approvaldao.updateApprovalAllow(approvalNo);

	}

	@Override
	public void updateApprovalReject(String approvalNo) {
		approvaldao.updateApprovalReject(approvalNo);

	}

	@Override
	public int getApprovalAccount() {
		return approvaldao.getApprovalAccount();
	}

	@Override
	public List<ApprovalVO> getApprovalTeacherType(Criteria cri, String approvalType, String userId) {
		if(approvalType.equals("all")) return approvaldao.getMyApprovalList(userId);
		return approvaldao.getApprovalTypeTeacher(cri, approvalType, userId);
	}

	@Override
	public void insertApproval(ApprovalVO approvalVO) {
		approvaldao.insertApproval(approvalVO);
		
	}

	@Override
	public List<ApprovalVO> getApprovalWaitList(String userId) {
		return approvaldao.getApprovalWaitList(userId);
	}

}
