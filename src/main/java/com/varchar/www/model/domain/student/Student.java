package com.varchar.www.model.domain.student;

import java.sql.Date;

import lombok.Data;





@Data
public class Student {
	private String userId;
	private int authorityCode;
	private int academicTypeCode;
	private String userPassword;
	private String userName;
	private String userTel;
	private String userParentTel;
	private Date userBirth;
	private String userEmail;
	private String userAddress;
	private String userImage;
	private Date userRegistration;
	private String userRemark;
	private String schoolName;
	private String recordNo;
	private String testSpacificationCode;
	private int koreanLanguage;
	private int math;
	private int english;
	private int social;
	private int science;
	private int koreanHistory;
	private String rank;
	
}
