package com.varchar.www.model.domain.manager;

import java.sql.Date;

import lombok.Data;

@Data
public class Season {
	private String seasonId;
	private String seasonName;
	private Date seasonStartDate;
	private Date seasonEndDate;
	private String seasonStartTime;
	private String seasonEndTime;
}
