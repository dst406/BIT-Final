package com.varchar.www.model.domain.lecture;

import java.sql.Date;

import lombok.Data;

@Data
public class LectureVO {
	
	//VO는 테이블1:1
	
	private String lectureCode;
	private String userId;
	private String seasonId;
	private String lectureSubjectCode;
	private int lectureRoomNo;
	private String lectureStateCode;
	private String lectureName;
	private String lectureContent;
	private Date lectureRegisterDate;
	private int lectureCost;
}
