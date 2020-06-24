package com.varchar.www.model.domain.manager;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class SupplierDTO {

	//구매처
	private int supplier_no; //구매처 번호
	private String supplier_name; //구매처명
	private String supplier_address; //구매처주소
	private String supplier_tel; //구매처 번호
	private Date supplier_date; //구매처 등록일
}
