package com.varchar.www.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private final UserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	

		http.csrf().disable().authorizeRequests()
				
				// 페이지 권한 설정
				.antMatchers("/**","/login","/new","/login/**","/board/**").permitAll()
				
				// /manager으로 시작하는 경로는 MANABER롤을 가진 사용자만 접근 가능
				.antMatchers("/manager/**").hasRole("MANAGER")
				// /teacher으로 시작하는 경로는 TEACHER롤을 가진 사용자만 접근 가능
				.antMatchers("/teacher/**").hasRole("TEACHER")
				.antMatchers("/student/**").hasRole("STUDENT")
			.and() // 로그인 설정
				.formLogin().loginPage("/login")
				// 로그인 성공할 경우 기본페이지
				.defaultSuccessUrl("/main")
				// 로그인 실패할 경우
				.failureUrl("/login/loginfail")
				// 로그인 시 파라미터로 id, password를 받음
				//.usernameParameter("id").passwordParameter("pw")
				.permitAll()
			.and() // 로그아웃 설정
				.logout()
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.logoutSuccessUrl("/login")
				.invalidateHttpSession(true)
			.and()
				.exceptionHandling().accessDeniedPage("/login/denied");

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
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
