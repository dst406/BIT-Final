package com.varchar.www.model.domain.manager;

import java.sql.Date;

import lombok.Data;

@Data
public class Season {
	private String season_id;
	private String season_name;
	private Date season_start_date;
	private Date season_end_date;
	private String season_start_time;
	private String season_end_time;
}
