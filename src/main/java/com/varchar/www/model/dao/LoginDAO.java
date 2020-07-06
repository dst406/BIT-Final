package com.varchar.www.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.varchar.www.login.AcademyUser;

@Mapper
public interface LoginDAO {
	AcademyUser getLoginUser(@Param("userId") String userId);
	void signUpUser(AcademyUser user);
}
