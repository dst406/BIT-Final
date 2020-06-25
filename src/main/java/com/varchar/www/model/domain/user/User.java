package com.varchar.www.model.domain.user;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
	private String userId;
	private String authorityCode;
	private String academyCode;
	private String password;
	private String username;
	private String tel;
	private String parentTel;
	private String birth;
	private String email;
	private String address;
	private String image;
	private Date registration;
	private String remark;
	private String schoolName;

}
