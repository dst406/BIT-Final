package com.varchar.www.model.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class LoginAuthenticationProvider implements AuthenticationProvider {
    
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
    
    
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		    String username = (String) authentication.getPrincipal();
	        String password = (String) authentication.getCredentials();
	        
	        System.out.println("getPrincipal  : "+username);
	        AcademyUser user = (AcademyUser) userDetailsServiceImpl.loadUserByUsername(username);
	        
	        
	        System.out.println("토큰에 있는 비번 :  "+password);
	        System.out.println("DB 있는 비번  :  "+user.getPassword());
	        System.out.println("권한 : "+user.getAuthorities());
	        if(! passwordEncoder().matches(password, user.getPassword())) {
	        	System.out.println("여기는 1  ");
	            throw new BadCredentialsException(username);
	        }
	        
	        System.out.println(user.isEnabled());
	        
	        if(! user.isEnabled()) {
	        	
	            throw new BadCredentialsException(username);
	        }
	        
	        System.out.println("비밀번호 TOKEN !!   : "+
	        		new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities())
	        		);
	        
	        return new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());
	}
	

	 
    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
    
//    private boolean matchPassword(String loginPwd, String password) {
//        return loginPwd.equals(password);
//    }
	
 
}


