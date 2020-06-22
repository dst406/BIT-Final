package com.varchar.www.controller.manager;

import org.springframework.web.bind.annotation.GetMapping;

public class ExpenditureController {

	@GetMapping("/expenditure")
	public String accounting() {
		
		return "manager/expenditure";
	}
}
