package com.varchar.www.model.service;

import java.util.List;


import com.varchar.www.model.domain.approval.ApprovalVO;
import com.varchar.www.model.domain.page.Criteria;

public interface ApprovalService {
	
	List<ApprovalVO> getApprovalList(Criteria cri);
	List<ApprovalVO> getMyApprovalList(String userId);
	List<ApprovalVO> getApprovalType(Criteria cri, String approvalType);
	List<ApprovalVO> getApprovalTeacherType(Criteria cri, String approvalType, String userId);
	void updateApprovalAllow(String approvalNo);
	void updateApprovalReject(String approvalNo);
	int getApprovalAccount();
	void insertApproval(ApprovalVO approvalVO);
	List<ApprovalVO> getApprovalWaitList(String userId);
}
