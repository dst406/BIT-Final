package com.varchar.www.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.varchar.www.model.domain.board.Board;
import com.varchar.www.model.domain.board.Season;

@Configuration
public class JavaBeanConfiguration {
	
	@Bean
	public LogAspectJ logAspectJ() { return new LogAspectJ(); }
	

	 @Bean public Board board() {return new Board();}
	 
	//  @Bean public Season season() {return new Season();}
}
