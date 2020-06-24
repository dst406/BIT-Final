package com.varchar.www.model.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.varchar.www.model.dao.MemberRepository;
import com.varchar.www.model.domain.user.Role;
import com.varchar.www.model.domain.user.Member;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{
	
	private final MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		System.out.println("userId="+userId);
		Member member = memberRepository.findById(userId)
				.orElseThrow(() -> new UsernameNotFoundException(userId));
		 System.out.println("loadUserByUsername userId==>"+userId +" \n"+ Role.MANAGER.getValue());
			System.out.println("member==="+member); 
	        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
	        
	    if(member.getAuthorityCode().equals("1")) {//원장 권한
	    	System.out.println("d    1");
	    	SimpleGrantedAuthority  authority=	new SimpleGrantedAuthority(Role.MANAGER.getValue());
	    	grantedAuthorities.add(authority);
	    	System.out.println(authority.getAuthority());
	    } else if(member.getAuthorityCode().equals("2")){//선생권한
	    	System.out.println("f    2");
	    	grantedAuthorities.add(new SimpleGrantedAuthority(Role.TEACHER.getValue()));
	    } else {// 학생
	    	grantedAuthorities.add(new SimpleGrantedAuthority(Role.STUDENT.getValue()));
	    }
	    User user = new User(member.getUserId(), member.getPassword(), grantedAuthorities);
	    System.out.println("loadUserByUsername:: user ==>" + user);
		return user;
	}
@Transactional
public String joinUser(Member member) {
	//비번 암호화
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	member.setPassword(passwordEncoder.encode(member.getPassword()));
	System.out.println("loadUserByUsername: encoder===>"+ member.getPassword());
	System.out.println("userId                   "+member.getUserId());
	System.out.println( ""+memberRepository.save(member).getUserId());
	return memberRepository.save(member).getUserId();
}
}
