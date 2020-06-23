package com.varchar.www.model.domain.teacher;

import java.sql.Date;

import lombok.Data;

//VO는 1:1 테이블 
//user테이블이지만 강사,원장파트이므로 Teacher로 명명합니다.
@Data
public class TeacherVO {
	private String userId; //강사에게 부여된 id
	private String authorityCode;
	private String userName; //강사명
	private String userPw;
	private String userTel; 
	private String userBirth;
	private String userEmail;
	private String userAddress;
	private Date userRegistration; //입사일
	private String userImage;
	private String userRemark; //비고 ex)강사&원장파트에서는 이곳에 담당과목을 명시합니다.
	

}
