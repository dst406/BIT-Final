package com.varchar.www;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.varchar.www.model.dao.DAOTest;


@SpringBootTest
class VarcharApplicationTests {

	@Test
	void contextLoads() {
	}
	
	
	@Autowired
	private DAOTest daoTest;
	
	@Test
	public void DB_CONNECT_TEST() {
		System.out.println(daoTest.getSeasonId());
	}
	
	public void boardGroup() {
		
		
		
	}
	
	
}
