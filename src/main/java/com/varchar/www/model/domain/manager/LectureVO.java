package com.varchar.www.model.domain.manager;

import java.sql.Date;

import lombok.Data;

@Data
public class LectureVO {
	
	private String lecture_code;
	private String user_id;
	private String season_id;
	private String lecture_subject_code;
	private int lectureRoom_no;
	private String lecture_state_code;
	private String lecture_name;
	private String lecture_content;
	private Date lecture_register_date;
	private int lecture_cost;
}
