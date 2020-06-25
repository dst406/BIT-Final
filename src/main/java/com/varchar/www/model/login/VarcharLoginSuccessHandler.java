package com.varchar.www.model.login;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import com.varchar.www.model.dao.LoginDAO;

public class VarcharLoginSuccessHandler implements AuthenticationSuccessHandler{
	
	@Autowired 
	LoginDAO loginDAO;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
			
		System.out.println("authName : "+auth.getName());
		System.out.println("auth : "+auth.getPrincipal());
		System.out.println("auth : "+auth.getAuthorities().toString());
		HttpSession session  = request.getSession();
		//session.setAttribute("user",loginDAO.getLoginUser(auth.getAuthorities().toString()));
		String url = "";
		
		switch (auth.getAuthorities().toString()) {
		case "[ROLE_STUDENT]":
			url = "/student/studentIndex";
			break;
		case "[ROLE_TEACHER]":
			url = "/getStudentListTeacher";
			//url = "/teacher/teacherIndex";
			break;
		case "[ROLE_MANAGER]":
			url = "/getStudentListManager";
			//url = "/manager/managerIndex";
			break;
		}
		System.out.println(url);
		
		response.sendRedirect(url);
		}
		

}
