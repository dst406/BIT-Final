package com.varchar.www.model.domain.manager;

import java.sql.Date;

import lombok.Data;

@Data
public class Lecture {
	
	private String lecture_code;
	private String lecture_name; //강의명 ex)영어는 더이상 외국어가 아닙니다 or 중1 기말고사대비 영어
	private String season_name; //강의 시즌명 ex)여름방학,1학기중간고사...
	private Date season_start_date; //시즌 시작일
	private Date season_end_date; //시즌 종료일
	private String lecture_state_name; //강의상태명 ex)강의중,강의예정
	private String capacity; //강의실과 강의를 들을 수 있는 학생의 정원
	private String student_grade; //학년
	private String user_name; 
	private int lecture_cost; //강의료
	private int lectureroom_no; //강의실 번호
	private String lecture_content; //강의를 간단하게 설명합니다.
	private String user_tel; // 담당강사 전화번호
	private String lecture_day;
	private String season_id;
	private String lecture_start_time;
	private String lecture_end_time;
	

}
