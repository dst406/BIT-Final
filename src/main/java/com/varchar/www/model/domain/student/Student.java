package com.varchar.www.model.domain.student;

import java.sql.Date;

import lombok.Data;

@Data
public class Student {
	private String userId;
	private String authorityCode;
	private String academicTypeName;
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

}
