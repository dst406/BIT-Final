package com.varchar.www.controller.manager;

import org.springframework.web.bind.annotation.GetMapping;

public class CategotyController {

	@GetMapping("/category")
	public String accounting() {
		
		return "manager/category";
	}
}
