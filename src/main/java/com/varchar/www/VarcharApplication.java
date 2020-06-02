package com.varchar.www;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.varchar.www.model.dao")
public class VarcharApplication {

	public static void main(String[] args) {
		SpringApplication.run(VarcharApplication.class, args);
	}

}
