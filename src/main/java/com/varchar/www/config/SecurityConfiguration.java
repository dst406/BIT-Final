package com.varchar.www.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

import com.varchar.www.login.LoginAuthenticationProvider;
import com.varchar.www.login.UserDetailsServiceImpl;
import com.varchar.www.login.VarcharLoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	LoginAuthenticationProvider loginAuthenticationProvider;
	


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				
				// 페이지 권한 설정
				.antMatchers("/login/**","/login","/signUp/**").permitAll()
				// /manager으로 시작하는 경로는 MANABER롤을 가진 사용자만 접근 가능
				.antMatchers("/manager/**").hasRole("MANAGER")
				// /teacher으로 시작하는 경로는 TEACHER롤을 가진 사용자만 접근 가능
				.antMatchers("/teacher/**").hasAnyRole("TEACHER","MANAGER")
				.antMatchers("/student/**").hasAnyRole("STUDENT")
				.antMatchers("/board/**").hasAnyRole("MANAGER","TEACHER","STUDENT")
				.and() // 로그인 설정
				.formLogin().loginPage("/login")
				// 로그인 성공할 경우 기본페이지
				.successHandler(new VarcharLoginSuccessHandler())
				// 로그인 실패할 경우
			.and()
				.exceptionHandling().accessDeniedPage("/denied")
				// 로그인 시 파라미터로 id, password를 받음
				//.usernameParameter("id").passwordParameter("pw")
//				.permitAll()
			.and() // 로그아웃 설정
				.logout()
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.logoutSuccessUrl("/login")
				.invalidateHttpSession(true)
			.and() 
				.csrf()
					.disable()
					.httpBasic();
			

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//provider를 못쓰는중..ㅠ \
		auth.authenticationProvider(loginAuthenticationProvider);
		//.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
		//auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
	}
	

	
	// 페이지 권한 설정
	@Override
	public void configure(WebSecurity web) throws Exception {
		// security인증 없이 무조건 통과
		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
	}
	
	@Bean
	public SpringSecurityDialect securityDialect() {
		return new SpringSecurityDialect();
	}
	
}
