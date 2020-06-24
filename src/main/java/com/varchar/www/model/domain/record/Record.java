package com.varchar.www.model.domain.record;

import java.sql.Date;

import lombok.Data;

@Data
public class Record {
	private String userId;
	private String userName;
	private String age;
	private String schoolName;
	private String testName;
	private String testKindCode;
	private String testNo;
	private String recordNo;
	private int koreanLanguage;
	private int english;
	private int math;
	private int social;
	private int science;
	private int koreanHistory;
	private int sum;
	private int avg;
	private String rank;
}
