package com.varchar.www.model.domain.manager;

import java.sql.Date;

import lombok.Data;

@Data
public class Teacher {
	private String user_id; //강사에게 부여된 id
	private String user_name; //강사명
	private String user_tel; 
	private String user_birth;
	private String user_email;
	private String user_address;
	private Date user_registration; //입사일
	private String user_remark; //비고 ex)강사&원장파트에서는 이곳에 담당과목을 명시합니다.
}
