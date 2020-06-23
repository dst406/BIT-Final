package com.varchar.www.model.domain.lecture;

import java.sql.Date;

import lombok.Data;

@Data
public class Lecture {
	
	private String lectureCode;
	private String lectureName; //강의명 ex)영어는 더이상 외국어가 아닙니다 or 중1 기말고사대비 영어
	private String seasonName; //강의 시즌명 ex)여름방학,1학기중간고사...
	private Date seasonStartDate; //시즌 시작일
	private Date seasonEndDate; //시즌 종료일
	private String lectureStateName; //강의상태명 ex)강의중,강의예정
	private String capacity; //강의실과 강의를 들을 수 있는 학생의 정원
	private String studentGrade; //학년
	private String userName; 
	private int lectureCost; //강의료
	private int lectureroomNo; //강의실 번호
	private String lectureContent; //강의를 간단하게 설명합니다.
	private String userTel; // 담당강사 전화번호
	private String lectureDay;
	private String seasonId;
	private String lectureStartTime;
	private String lectureEndTime;
	

}
