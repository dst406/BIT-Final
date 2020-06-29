package com.varchar.www.login;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.varchar.www.model.domain.user.Member;
import com.varchar.www.model.service.LoginService;

@Controller
public class LoginController {

	
	// private final PasswordEncoder passwordEncoder;
	
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	LoginService loginService;

	// 학원로그인페이지
	@RequestMapping(value = "/login" , method = { RequestMethod.GET, RequestMethod.POST })
	public String selectLogin(	HttpServletRequest request, Authentication auth) {
		
		return "login/login";
	}

	// 접근 거부페이지
	@GetMapping("/login/denied")
	public String loginDenied() {
		return "login/denied";
	}

	// 로그인 실패
	@GetMapping("/login/loginfail")
	public String loginfail() {
		return "login/loginfail";
	}

	// 모든사용자 로그인 성공 시 공통 기본페이지
	/*
	 * @GetMapping("/main") public String loginMain() { return "/login/main"; }
	 */
	@GetMapping("/manager/main")
	public String managerMainPage(@AuthenticationPrincipal User user, Map<String, Object> model, Session session) {

		// model.put("members", members);
		// model.put("currentMemberId", user.getUsername());
		return "login/main";
	}

	@GetMapping("/main")
	public String mainPage(@AuthenticationPrincipal AcademyUser user, Model model, HttpServletRequest request,
			Authentication auth) {

		System.out.println("///////////////////////////////////////////////////////////////////");
		System.out.println(auth.getPrincipal());
		System.out.println("///////////////////////////////////////////////////////////////////");
		/////////////////////////////////////////////////////////////////////////
		// 세션 상세 정보 확인
		/////////////////////////////////////////////////////////////////////////
		HttpSession session = request.getSession();
		Enumeration<?> attributeNames = session.getAttributeNames();
		while (attributeNames.hasMoreElements()) {
			String name = (String) attributeNames.nextElement();
			if (name.equals("SPRING_SECURITY_CONTEXT")) {
				SecurityContext value = (SecurityContext) session.getAttribute(name);
				Authentication authentication = value.getAuthentication();
				//AcademyUser principal = (AcademyUser) authentication.getPrincipal();
				System.out.println("principal "+authentication.getPrincipal());
				WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();
				String username = authentication.getName();
				String password = (String) authentication.getCredentials();
				System.out.println(" \n\n\n ");
				System.out.println("///////////////////////////////////////////////////////////////////");
				System.out.println("////////////////////SPRING_SECURITY_CONTEXT ///////////////////////");
				System.out.println("///////////////////////////////////////////////////////////////////");
				System.out.println("name = " + name + " , value = " + value.toString());
				System.out.println("authentication : " + authentication.toString());
				//System.out.println("principal : " + principal);
				System.out.println("details : " + details.toString());
				System.out.println("username : " + username);
				System.out.println("password : " + password);
				System.out.println(" \n\n\n ");
			}
			
		}
		model.addAttribute("user", loginService.getLoginUser((String)auth.getPrincipal()));
		// model.put("members", members);
		// model.put("currentMemberId", user.getUsername());
		return "login/main";
	}

	// 원장(관리자)
	// 메인에서 이동
	@GetMapping("/manager/manager")
	public String loginManager(@AuthenticationPrincipal User user, Model model) {
		model.addAttribute("currentMemberId", user.getUsername());
		System.out.println("manager/manager");
		return "/login/manager";
	}

	@GetMapping("/manager")
	public String managerPage(@AuthenticationPrincipal User user, Map<String, Object> model) {
		System.out.println("33333333333333");
		model.put("currentAdminId", user.getUsername());
		return "login/manager";
	}

	// 강사
	// 메인에서 이동
	@GetMapping("/teacher/teacher")
	public String loginTeacher(@AuthenticationPrincipal User user, Map<String, Object> model,Authentication auth) {
		System.out.println("login cont   : "+auth.getPrincipal());
		return "login/teacher";
	}

	// 학생
	// 메인에서 이동
	@GetMapping("/student/student")
	public String loginStudent(@AuthenticationPrincipal User user, Map<String, Object> model) {

		model.put("currentAdminId", user.getUsername());
		return "login/student";
	}

	@GetMapping("/signup")
	public String userSignUpForm(@ModelAttribute AcademyUser academyUser) {
		return "login/signUp";
	}
	
	@PostMapping("/signup")
	public String userSignUp(@ModelAttribute AcademyUser academyUser) {
		System.out.println("?");
		userDetailsServiceImpl.joinUser(academyUser);
		
		return "redirect:/login";
	}
	

//	@PostMapping({"/new","/signup"})
//	public String execSignup(Member member) {
//		System.out.println("execSignup:"+member);
//		member.setPassword(passwordEncoder.encode(member.getPassword()));
//		memberRepository.save(member);
//
//		return "redirect:/login";
//	}

}
