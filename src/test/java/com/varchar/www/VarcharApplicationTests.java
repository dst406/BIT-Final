package com.varchar.www;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.varchar.www.model.dao.BoardDAO;
import com.varchar.www.model.dao.DAOTest;

import lombok.extern.java.Log;


@SpringBootTest
@Log
class VarcharApplicationTests {

	@Test
	void contextLoads() {
	}
	
	
	@Autowired
	private DAOTest daoTest;
	
	@Autowired private BoardDAO boardDAO;
	
	
	
	@Test
	public void boardGroupListTest() {
		try {
		//log.info();
			System.out.println(boardDAO.getNavbar("jin2020","2").toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//@Test
	public void DB_CONNECT_TEST() {
		System.out.println(daoTest.getSeasonId());
	}
	
	public void boardGroup() {
		
		
		
	}
	
	
}
