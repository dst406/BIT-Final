package com.varchar.www.model.domain.manager;

import java.sql.Date;

import lombok.Data;

@Data
public class IncomeDTO {
	
	//수입
	private int payment_no; //결제번호
	private String user_id; //사용자id
	private int lecture_no; // 강의번호
	private int payment_method_no; //결제수단번호
	private Date payment_date; //결제일
	private int lecture_room_no; //강의실 번호
	
	//결제수단
	private String payment_method_name; //결제수단
	private int onoff_payment_no; //온오프라인 결제번호
	private String onoff_payment; //온오프라인 결제
}
