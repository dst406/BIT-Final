package com.varchar.www.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.varchar.www.model.domain.approval.ApprovalVO;
import com.varchar.www.model.domain.page.Criteria;

@Mapper
public interface ApprovalDAO {
	
	List<ApprovalVO> getApprovalList(@Param("cri") Criteria cri);
	List<ApprovalVO> getMyApprovalList(String userId);
	List<ApprovalVO> getApprovalType(@Param("cri") Criteria cri,@Param("approvalType") String approvalType);
	List<ApprovalVO> getApprovalTypeTeacher(@Param("cri") Criteria cri, @Param("approvalType") String approvalType, @Param("userId") String userId);
	void updateApprovalAllow(String approvalNo); //원장의  결재승인
	void updateApprovalReject(String approvalNo); //원장의 결재반려
	int getApprovalAccount();
	void insertApproval(ApprovalVO approvalVO);
	List<ApprovalVO> getApprovalWaitList(String userId);
}
