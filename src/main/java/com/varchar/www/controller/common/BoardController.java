package com.varchar.www.controller.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.varchar.www.model.dao.DAOTest;

@Controller
public class BoardController {
	
	@GetMapping("/")
	public String index() {
		return "student/studentInfo";
	}
	
}
