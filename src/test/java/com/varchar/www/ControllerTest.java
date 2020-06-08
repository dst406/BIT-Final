package com.varchar.www;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.varchar.www.model.domain.board.Board;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
	
		@Autowired
	  	public MockMvc mock ;
	
	  
	  	@Test
	  	public void mockTest() {
	  		try {
				mock.perform(MockMvcRequestBuilders.get("/postList").param("boardNo","6666"))
				.andDo(print());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// COMPOSE -COFFEE-
				
			}
	  	}
	
}
