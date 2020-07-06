package com.varchar.www.model.service;

import org.apache.ibatis.annotations.Param;

import com.varchar.www.login.AcademyUser;

public interface LoginService {
	AcademyUser getLoginUser(@Param("userId") String userId);
	void signUpUser(AcademyUser user);
}
