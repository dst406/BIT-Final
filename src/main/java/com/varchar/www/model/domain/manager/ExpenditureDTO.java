package com.varchar.www.model.domain.manager;

import java.sql.Date;

import lombok.Data;

@Data
public class ExpenditureDTO {
	
	//지출
	private int expenditure_no;
	private String expenditure_contents;
	private Date expenditure_date;
	private String expenditure_person;
	
	//변동지출
	private int variable_expenditure;
	//고정지출
	private String fixed_expenditure;
	
	
	
	
}
