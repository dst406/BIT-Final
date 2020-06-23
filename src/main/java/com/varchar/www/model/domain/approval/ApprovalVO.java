package com.varchar.www.model.domain.approval;

import lombok.Data;

@Data
public class ApprovalVO {
	
	private String approvalNo;
	private String approvalTypeCode;
	private String approvalTypeName;
	private String approvalStateCode;
	private String approvalStateName;
	private String userId;
	private String userName;
	private String approvalContent;
	private String approvalRegisterDate;

}

