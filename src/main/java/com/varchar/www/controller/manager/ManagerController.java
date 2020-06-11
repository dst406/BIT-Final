package com.varchar.www.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagerController {
	
	
	//원장의 메인화면입니다.
	@GetMapping("/managerIndex")
	public String managerIndex() {
		return"/main/managerIndex";
	}
	
	
}
