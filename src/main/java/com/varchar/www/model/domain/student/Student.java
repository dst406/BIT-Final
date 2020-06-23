package com.varchar.www.model.domain.student;

import java.sql.Date;

import lombok.Data;

@Data
public class Student {
	private String user_id;
	private int authority_code;
	private int academic_type_code;
	private String user_password;
	private String user_name;
	private String user_tel;
	private String user_parent_tel;
	private Date user_birth;
	private String user_email;
	private String user_address;
	private String user_image;
	private Date user_registration;
	private String user_remark;
	private String school_name;
//	private String record_no;
//	private String test_spacification_code;
//	private int korean_language;
//	private int math;
//	private int english;
//	private int social;
//	private int science;
//	private int korean_history;
//	private String rank;
	
}
