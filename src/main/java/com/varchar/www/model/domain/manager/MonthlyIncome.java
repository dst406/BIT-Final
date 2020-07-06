package com.varchar.www.model.domain.manager;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class MonthlyIncome {
	
	private String paymentDate;
	private List<Income> income; 
	
}
