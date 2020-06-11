package com.varchar.www.model.domain.manager;

public class LectureTimeTable {
	
	private String lecture_day; //각 강의의 요일을 할당해줍니다.
	private String lecture_code; 
	private String lecture_season_id;
	private String lecture_allocation; //각 강의마다 시간을 할당해줍니다. ex)영어는2시간을 과학은1시간..
	private String lecture_start_time; //각 강의의 시작시간을 지정해줍니다.
	private String lecture_end_time; //각 강의의 종료시간을 지정해줍니다.

}
