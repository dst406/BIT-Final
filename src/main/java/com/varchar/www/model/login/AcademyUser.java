package com.varchar.www.model.login;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.varchar.www.model.domain.user.Role;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@SuppressWarnings("serial")
public class AcademyUser implements UserDetails{
	private String userId;
	private String authorityCode;
	private String academyCode;
	private String password ;
	private String userName;
	private String tel;
	private String parentTel;
	private String birth;
	private String email;
	private String address;
	private String image;
	private Date registration;
	private String remark;
	private String schoolName;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		 ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		 
		 if(getAuthorityCode().equals("1")) {//원장 권한
			 
		    	SimpleGrantedAuthority  authority=	new SimpleGrantedAuthority(Role.MANAGER.getValue());
		    	grantedAuthorities.add(authority);
		    	
		    } else if(getAuthorityCode().equals("2")){//선생권한
		    	
		    	grantedAuthorities.add(new SimpleGrantedAuthority(Role.TEACHER.getValue()));
		    	
		    } else {// 학생
		    	
		    	grantedAuthorities.add(new SimpleGrantedAuthority(Role.STUDENT.getValue()));
		    	
		    }
	        return grantedAuthorities;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
	@Override
	public String getPassword() {
		return password;
	}
	
	public String getUserName() {
		return userName;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}


}
