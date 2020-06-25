package com.varchar.www.model.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varchar.www.model.dao.LoginDAO;
import com.varchar.www.model.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginDAO loginDAO;
	
	
	@Override
	public AcademyUser getLoginUser(String userId) {
		return loginDAO.getLoginUser(userId);
	}
}
