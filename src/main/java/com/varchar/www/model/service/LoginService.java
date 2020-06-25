package com.varchar.www.model.service;

import com.varchar.www.model.login.AcademyUser;

public interface LoginService {
	AcademyUser getLoginUser(String userId);
}
