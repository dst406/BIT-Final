package com.varchar.www.model.domain.user;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "ACADEMY_USER")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Table(name = "ACADEMY_USER")
public class Member {
	@Id
	private @Column(name= "USER_ID") String userId;
	private @Column(name= "AUTHORITY_CODE") String authorityCode;
	private @Column(name= "ACADEMIC_TYPE_CODE") String academyCode;
	private @Column(name= "USER_PASSWORD") String password;
	private @Column(name= "USER_NAME") String username;
	private @Column(name= "USER_TEL") String tel;
	private @Column(name= "USER_PARENT_TEL") String parentTel;
	private @Column(name= "USER_BIRTH") String birth;
	private @Column(name= "USER_EMAIL") String email;
	private @Column(name= "USER_ADDRESS") String address;
	private @Column(name= "USER_IMAGE") String image;
	private @Column(name= "USER_REGISTRATION") Date registration;
	private @Column(name= "USER_REMARK") String remark;
	private @Column(name= "SCHOOL_NAME") String schoolName;
	
	
//	public Member(String id, String authorityCode, String academyCode, String pw, String name, String tel, String parentTel, String birth, String email, String address,
//			String image, Date registration, String remark, String schoolName) {
//		this.id = id;
//		this.authorityCode = authorityCode;
//		this.academyCode = academyCode;
//		this.pw = pw;
//		this.name = name;
//		this.tel = tel;
//		this.parentTel = parentTel;
//		this.birth = birth;
//		this.email = email;
//		this.address = address;
//		this.image = image;
//		this.registration = registration;
//		this.remark = remark;
//		this.schoolName = schoolName;
//	}
//	public void setPw(String pw) {
//		this.pw = pw;
//	}
}
