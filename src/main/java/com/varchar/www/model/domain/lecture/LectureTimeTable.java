package com.varchar.www.model.domain.lecture;

import lombok.Data;

@Data
public class LectureTimeTable {
	
	private int lectureTimeTableNo; 
	private String lectureDay; //각 강의의 요일을 할당해줍니다.
	private String lectureCode; 
	private String lectureSeasonId;
	private String lectureAllocation; //각 강의마다 시간을 할당해줍니다. ex)영어는2시간을 과학은1시간..
	private String lectureStartTime; //각 강의의 시작시간을 지정해줍니다.
	private String lectureEndTime; //각 강의의 종료시간을 지정해줍니다.

}
