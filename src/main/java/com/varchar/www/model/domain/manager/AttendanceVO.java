package com.varchar.www.model.domain.manager;

import java.sql.Date;

import lombok.Data;

@Data
public class AttendanceVO {
	
	//강사출퇴근부로 쓰이는 출결 1:1테이블
	
	private String attendanceNo; // 자동증가
	private String userId; 
	private String attendanceStateCode; //출결상태를 나타내는 코드입니다.
	private Date attendanceComeTime; //출근시간입니다.
	private Date attendanceGoTime; //퇴근시간입니다.
	
	

}
