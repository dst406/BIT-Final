package com.varchar.www.controller.manager;

import org.springframework.web.bind.annotation.GetMapping;

public class SupplierController {

	@GetMapping("/supplier")
	public String accounting() {
		
		return "manager/supplier";
	}
}
