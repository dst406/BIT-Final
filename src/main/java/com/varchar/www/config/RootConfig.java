package com.varchar.www.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class RootConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploadImg/**")
                .addResourceLocations("classpath:/static/img/uploadImg/");
        registry.addResourceHandler("/userImg/**")
        		.addResourceLocations("classpath:/static/img/userImg/");
        registry.addResourceHandler("/mainImg/**")
        		.addResourceLocations("classpath:/static/img/mainImg/");
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/js/**")
                .addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/img/**")
                .addResourceLocations("classpath:/static/img/");
        registry.addResourceHandler("/icon/**")
                .addResourceLocations("classpath:/static/icon/");

    }

	
}
