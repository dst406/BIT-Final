package com.varchar.www.model.dao;

import com.varchar.www.model.login.AcademyUser;

public interface LoginDAO {
	AcademyUser getLoginUser(String userId);
	void signUpUser(AcademyUser user);
}
