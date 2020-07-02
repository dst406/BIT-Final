package com.varchar.www.login;

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

    
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		    String username = (String) authentication.getPrincipal();
	        String password = (String) authentication.getCredentials();
	        
	        AcademyUser user = (AcademyUser) userDetailsServiceImpl.loadUserByUsername(username);
	        
	        if(! new BCryptPasswordEncoder().matches(password, user.getPassword())) 
	        	throw new BadCredentialsException("잘못된 아이디이거나 비밀번호가 일치하지 않습니다.");
	        
	        if(! user.isEnabled()) 
	            throw new BadCredentialsException("잘못된 아이디이거나 비밀번호가 일치하지 않습니다.");

	        user.setUserPassword(null);
	        
	        return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
	}
	

	 
    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

 
}


