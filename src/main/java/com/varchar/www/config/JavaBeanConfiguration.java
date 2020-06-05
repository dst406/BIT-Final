package com.varchar.www.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import com.varchar.www.model.domain.board.Board;

@Configuration
public class JavaBeanConfiguration {
	
	@Bean
	public LogAspectJ logAspectJ() { return new LogAspectJ(); }
	

	 @Bean public Board board() {return new Board();}
	 
	//  @Bean public Season season() {return new Season();}
	 
	 
	 
	

	 @Bean
	 public MultipartResolver multipartResolver() {
	     return new StandardServletMultipartResolver();
	 }
	 
}
