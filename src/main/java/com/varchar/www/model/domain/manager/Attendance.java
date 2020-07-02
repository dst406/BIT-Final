package com.varchar.www.model.domain.manager;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data

//강사,학생 출퇴근부를 위한 조인테이블 입니다.
public class Attendance {
	
	private String attendanceNo;
	private String authorityCode;//학생과 강사를 구분지어 출력하기위해 필요함.
	private String userName; 
	private String userTel;
	private String attendanceStateCode; //출결상태를 나타내는 코드입니다.
	private String attendanceStateName;
	private String attendanceComeTime; //출근시간

	private String attendanceGoTime; //퇴근시간


}
