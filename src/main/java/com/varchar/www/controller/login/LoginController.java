package com.varchar.www.controller.login;




import java.util.List;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.varchar.www.model.domain.user.Member;
import com.varchar.www.model.dao.MemberRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {
	private final MemberRepository memberRepository;

	private final PasswordEncoder passwordEncoder;
	// 학원로그인페이지
	@GetMapping("/login")
	public String selectLogin() {
		System.out.println("===> dispLogin()");
		return "/login/login";
	}

	// 접근 거부페이지
	@GetMapping("/login/denied")
	public String loginDenied() {
		return "/login/denied";
	}
	//로그인 실패
	@GetMapping("/login/loginfail")
	public String loginfail() {
		return "/login/loginfail";
	}
	// 모든사용자 로그인 성공 시 공통 기본페이지
	/*
	 * @GetMapping("/main") public String loginMain() { return "/login/main"; }
	 */
	@GetMapping("/manager/main")
	public String managerMainPage(@AuthenticationPrincipal User user, Map<String, Object> model) {
		List<Member> members = memberRepository.findAll();
		//model.put("members", members);
		//model.put("currentMemberId", user.getUsername());
		return "/login/main";
	}

	@GetMapping("/main")
	public String mainPage(@AuthenticationPrincipal User user, Map<String, Object> model) {
		List<Member> members = memberRepository.findAll();
		//model.put("members", members);
		//model.put("currentMemberId", user.getUsername());
		return "/login/main";
	}
	
	/*
	 * .antMatchers("/manager/**").hasRole("MANAGER") 
	 * // /teacher으로 시작하는 경로는
	 * TEACHER롤을 가진 사용자만 접근 가능 
	 * .antMatchers("/teacher/**").hasRole("TEACHER")
	 * .antMatchers("/student/**").hasRole("STUDENT")
	 */
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
		return "/login/manager";
	}

	// 강사
	// 메인에서 이동
	@GetMapping("/teacher/teacher")
	public String loginTeacher(@AuthenticationPrincipal User user, Map<String, Object> model) {
		
		model.put("currentAdminId", user.getUsername());
		return "/login/teacher";
	}
	
	//학생
	//메인에서 이동
	@GetMapping("/student/student")
	public String loginStudent(@AuthenticationPrincipal User user, Map<String, Object> model) {
		
		model.put("currentAdminId", user.getUsername());
		return "/login/student";
	}
	
	@GetMapping("/signup")
	public String memberJoinForm(@ModelAttribute Member member) {
		return "login/memberJoinForm";
	}
	@PostMapping({"/new","/signup"})
	public String execSignup(Member member) {
		System.out.println("execSignup:"+member);
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		memberRepository.save(member);

		return "redirect:/login";
	}
	
}
