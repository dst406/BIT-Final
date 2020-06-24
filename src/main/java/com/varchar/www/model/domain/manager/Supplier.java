package com.varchar.www.model.domain.manager;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Supplier {

	//구매처
	private int supplierNo; //구매처 번호
	private String supplierName; //구매처명
	private String supplierAddress; //구매처주소
	private String supplierTel; //구매처 번호
	private Date supplierDate; //구매처 등록일
}
