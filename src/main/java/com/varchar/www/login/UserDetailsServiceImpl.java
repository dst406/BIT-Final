package com.varchar.www.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.varchar.www.model.dao.LoginDAO;
//@Service
//@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	LoginDAO loginDAO;
	
	public UserDetailsServiceImpl() {}
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		AcademyUser academyUser = loginDAO.getLoginUser(userId);
		
		if( academyUser == null) {throw new UsernameNotFoundException("잘못된 아이디이거나 비밀번호가 일치하지 않습니다."); }
	   
		return academyUser;
	}
	
	@Transactional
	public void joinUser(AcademyUser user) {
		//비번 암호화
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setUserPassword(passwordEncoder.encode(user.getPassword()));
		System.out.println("loadUserByUsername: encoder===>"+ user.getPassword());
		System.out.println("userId                   "+user.getUserId());
		loginDAO.signUpUser(user);
	}
}
