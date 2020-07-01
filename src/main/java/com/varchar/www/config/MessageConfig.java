package com.varchar.www.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration

public class MessageConfig {
	@Bean
	public MessageSource  messageSource() { 
		
		Locale.setDefault(Locale.KOREA);
		ReloadableResourceBundleMessageSource  source = new ReloadableResourceBundleMessageSource(); 
		/* encoding 룰 설정 */ 
		source.setDefaultEncoding("UTF-8");
		
		/* message properties 위치 설정 */
		source.setBasenames("classpath:messages/security_message", "classpath:org/springframework/security/messages"); 
		
		/* 5초간 케싱*/ 
		source.setCacheSeconds(5); 
		return source; 
		}


}
