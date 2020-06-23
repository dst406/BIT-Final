package com.varchar.www.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.varchar.www.model.domain.approval.ApprovalVO;

@Mapper
public interface ApprovalDAO {
	
	List<ApprovalVO> getApprovalList();
	List<ApprovalVO> getMyApprovalList(String userId);
	List<ApprovalVO> getApprovalType(String approvalType);
	void updateApprovalAllow(String approvalNo);
	void updateApprovalReject(String approvalNo);

}
