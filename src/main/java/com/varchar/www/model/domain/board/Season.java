package com.varchar.www.model.domain.board;

import java.sql.Date;

import lombok.Data;

@Data
public class Season {
	private String seasonId;
	private String seasonName;
	private Date seasonStartDate;
	private Date seasonEndDate;
	private String seasonClassStartTime;
	private String seasonClassEndTime;
//	
//	private String season_id;
//	private String season_name;
//	private Date season_start_date;
//	private Date season_end_date;
//	private String season_class_start_time;
//	private String season_class_end_time;
	
	
}
