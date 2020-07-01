package com.varchar.www.model.domain.teacher;

import java.sql.Date;

import lombok.Data;

//원장이 강사를 등록할때 필요한 항목들을 나열한 클래스입니다.
@Data
public class Teacher {
	
	private String userImage; //강사 이미지
	private String authorityCode;
	private String authorityName;
	private String userName;
	private String userId;
	private String userPw;
	private String userBirth;
	private String userBirthEnco;
	private String userTel;
	private String userEmail;
	private String userAddress;
	private String userRemark;
	private String lectureSubjectCode;
	private String lectureSubjectName;
	private Date userRegistration; //입사일
	
	
	private String academicBackGround; //최종학력
	private String careerPeriod; //경력기간
	private String careerLocation; //근무처
	private String careerContent; //근무내용
	
	
}
