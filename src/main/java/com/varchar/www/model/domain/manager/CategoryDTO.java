package com.varchar.www.model.domain.manager;

import lombok.Data;

@Data
public class CategoryDTO {
	//변동지출 카테고리
	private int variable_category_no;//카테고리번호
	private String variable_cotegory_name;//카테고리명
	private int variable_parent_no;//상위카테고리번호
	
	//고정지출 카테고리
	private int fixed_category_no;//카테고리번호
	private String fixed_category_name;//카테고리명
	private int fixed_parent_no;//상위카테고리번호
		
}
