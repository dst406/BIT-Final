package com.varchar.www.model.service;

import java.util.List;


import com.varchar.www.model.domain.approval.ApprovalVO;

public interface ApprovalService {
	
	List<ApprovalVO> getApprovalList();
	List<ApprovalVO> getMyApprovalList(String userId);
	List<ApprovalVO> getApprovalType(String approvalType);
	void updateApprovalAllow(String approvalNo);
	void updateApprovalReject(String approvalNo);

}
