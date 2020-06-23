package com.varchar.www.model.domain.user;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
//ROLE
public enum Role{
	MANAGER("ROLE_MANAGER"), 
	TEACHER("ROLE_TEACHER"),
	STUDENT("ROLE_STUDENT");
	
	private String value;
}
