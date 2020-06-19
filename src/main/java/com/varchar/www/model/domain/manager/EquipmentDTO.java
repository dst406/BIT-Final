package com.varchar.www.model.domain.manager;

import lombok.Data;

@Data
public class EquipmentDTO {
	
	//구매처별 제품분류(재고)
	private int equipment_no; //제품번호
	private String equipment_name; //제품명
	private String manufactured_by; //제조사
	private String equipment_unit; //단위
	private int equipment_unit_price; //단가
	private int equipment_count; //재고량

}
