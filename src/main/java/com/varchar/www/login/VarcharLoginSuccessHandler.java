package com.varchar.www.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.varchar.www.model.dao.LoginDAO;
import com.varchar.www.model.service.LoginService;

public class VarcharLoginSuccessHandler implements AuthenticationSuccessHandler{
	
	@Autowired 
	private LoginService loginService;
	
	@Autowired
	private LoginDAO loginDAO;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
	
		String url = "";
		
		//session.setAttribute("user", auth.getPrincipal());
		
		switch (auth.getAuthorities().toString()) {
		case "[ROLE_STUDENT]":
			url = "/board/postList";
			break;
		case "[ROLE_TEACHER]":
			//url = "/teacher/teacher";
			url = "/teacher/teacherIndex";
			break;
		case "[ROLE_MANAGER]":
			url = "/manager/managerIndex";
			//url = "/manager/managerIndex";
			break;
		}
		
		response.sendRedirect(url);
		}
		

}
