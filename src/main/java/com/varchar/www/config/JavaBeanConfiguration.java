package com.varchar.www.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaBeanConfiguration {
	
	@Bean
	public LogAspectJ logAspectJ() { return new LogAspectJ(); }
	

}
