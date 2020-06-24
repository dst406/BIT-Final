package com.varchar.www;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
	
		@Autowired
	  	public MockMvc mockMvc ;
		

	  	
	  	//@Test
	  	@DisplayName("GET 게시글 그룹 Controller")
	  	public void getBoardGroupTest() {
	  		try {
	  			this.mockMvc.perform(  get("/getNavbar/jin2020"))
						.andDo(print())
						.andExpect(status().isOk()
								);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  	}
	  	
	  	
	  	
	  	@Test
	  	@DisplayName("GET 게시글List ")
	  	public void getPostList() {
	  		try {
	  			this.mockMvc.perform(  get("/board/postList/2"))
						.andDo(print())
						.andExpect(status().isOk()
								);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  	}
	  	
	  	
}
