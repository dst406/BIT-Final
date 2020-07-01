package com.varchar.www.model.domain.student;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Payment {
	private int paymentMethodNo;
	private String userId;
	private int lectureCode;
	
}
