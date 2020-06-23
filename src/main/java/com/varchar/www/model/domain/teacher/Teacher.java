package com.varchar.www.model.domain.teacher;

import java.sql.Date;

import lombok.Data;

//원장이 강사를 등록할때 필요한 항목들을 나열한 클래스입니다.
@Data
public class Teacher {
	
	public String userImage; //강사 이미지
	public String authorityCode;
	public String userName;
	public String userId;
	public String userPw;
	public String userBirth;
	public String userTel;
	public String userEmail;
	public String userAddress;
	public String userRemark;
	public String lectureSubjectCode;
	public String lectureSubjectName;
	public Date userRegistration; //입사일
	public String academicBackGround; //최종학력
	public String careerPeriod; //경력기간
	public String careerLocation; //근무처
	public String careerContent; //근무내용
	
	
}
