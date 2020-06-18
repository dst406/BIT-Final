package com.varchar.www.model.domain.manager;

import java.sql.Date;

import lombok.Data;

@Data
public class ExpenditureDTO {
	
	
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
	
	//지출
	private int expenditure_no;
	private String expenditure_contents;
	private Date expenditure_date;
	private String expenditure_person;
	
	//변동지출
	
	private int variable_expenditure;
	
	//변동지출 카테고리
	private int variable_category_no;//카테고리번호
	private String variable_cotegory_name;//카테고리명
	private int variable_parent_no;//상위카테고리번호
	
	//고정지출
	private String fixed_expenditure;
	
	//고정지출 카테고리
	private int fixed_category_no;//카테고리번호
	private String fixed_category_name;//카테고리명
	private int fixed_parent_no;//상위카테고리번호
	
	//구매처
	private int supplier_no; //구매처 번호
	private String supplier_name; //구매처명
	private String supplier_address; //구매처주소
	private String supplier_tel; //구매처 번호
	private Date supplier_date; //구매처 등록일
	
	//구매처별 제품분류(재고)
	private int equipment_no; //제품번호
	private String equipment_name; //제품명
	private String manufactured_by; //제조사
	private String equipment_unit; //단위
	private int equipment_unit_price; //단가
	private int equipment_count; //재고량
	
	
	 
	
	
}
