package com.varchar.www.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
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
			
		System.out.println("auth name : "+auth.getName());
		
		System.out.println("auth principal : "+auth.getPrincipal());
		
		System.out.println("auth authority: "+auth.getAuthorities().toString());
		
		System.out.println("auth :       "+auth);
		
		HttpSession session  = request.getSession();
		String url = "";
		
		System.out.println("DB 유저값  : " +   auth.getPrincipal());
		session.setAttribute("user", auth.getPrincipal());
		System.out.println("session : "+session.getAttribute("user"));
		
		
		
		switch (auth.getAuthorities().toString()) {
		case "[ROLE_STUDENT]":
			url = "/student/studentIndex";
			break;
		case "[ROLE_TEACHER]":
			//url = "/teacher/teacher";
			url = "/teacher/teacherIndex";
			break;
		case "[ROLE_MANAGER]":
			url = "/getStudentListManager";
			//url = "/manager/managerIndex";
			break;
		}
		System.out.println("url  "+url);
		
		response.sendRedirect(url);
		}
		

}
