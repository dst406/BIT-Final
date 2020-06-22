package com.varchar.www.controller.manager;

import org.springframework.web.bind.annotation.GetMapping;

public class IncomeController {

	@GetMapping("/income")
	public String accounting() {
		
		return "manager/income";
	}
}
