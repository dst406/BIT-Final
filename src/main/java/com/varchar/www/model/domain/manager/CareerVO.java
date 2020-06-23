package com.varchar.www.model.domain.manager;

import lombok.Data;

@Data
public class CareerVO {
	
	private int careerNo; //경력번호
	private String userId; 
	private String careerPeriod; //경력기간
	private String careerLocation; //근무처
	private String careerContent; //근무내용
	private String academicBackGround; //최종학력

}