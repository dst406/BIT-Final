package com.varchar.www.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import com.varchar.www.login.AcademyUser;
import com.varchar.www.login.LoginAuthenticationProvider;
import com.varchar.www.login.UserDetailsServiceImpl;
import com.varchar.www.login.VarcharLoginSuccessHandler;
import com.varchar.www.model.domain.board.Board;
import com.varchar.www.model.domain.board.BoardGroup;
import com.varchar.www.model.domain.board.BoardGroupList;
import com.varchar.www.model.domain.board.PostDetail;
import com.varchar.www.model.domain.board.Posts;
import com.varchar.www.model.domain.board.PostsDetailList;
import com.varchar.www.model.domain.board.PostsList;
import com.varchar.www.model.domain.comment.ReplyComment;
import com.varchar.www.model.domain.student.Payment;

@Configuration
public class JavaBeanConfiguration {
	
	@Bean
	public LogAspectJ logAspectJ() { return new LogAspectJ(); }
	 
	//  @Bean public Season season() {return new Season();}
	 
	 @Bean public Board board() {return new Board();}
	 @Bean public BoardGroup boardGroup() {return new BoardGroup();}
	 @Bean public BoardGroupList boardGroupList() {return new BoardGroupList();}

	 @Bean public Posts posts() {return new Posts();}
	 @Bean public PostsList postsList() {return new PostsList();}
	 @Bean public PostDetail postDetail() {return new PostDetail();}
	 @Bean public PostsDetailList postsDetailList() {return new PostsDetailList();}
	 @Bean public ReplyComment replyComment() {return new ReplyComment();}
	 
	 // Login
	 @Bean public AcademyUser academyUser() {return new AcademyUser();}
	 @Bean public UserDetailsServiceImpl userService() {return new UserDetailsServiceImpl();}
	 @Bean public LoginAuthenticationProvider loginAuthenticationProvider() {return new LoginAuthenticationProvider();}
	 @Bean public VarcharLoginSuccessHandler varcharLoginSuccessHandler() {return new VarcharLoginSuccessHandler();}
	 @Bean public BCryptPasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }
	 
	 
	 //Student 
	 @Bean public Payment payment(){ return new Payment();}
	 
	 @Bean
	 public MultipartResolver multipartResolver() {
	     return new StandardServletMultipartResolver();
	 }
	 
}
