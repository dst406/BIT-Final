package com.varchar.www.controller.manager;

import org.springframework.web.bind.annotation.GetMapping;

public class EquipmentController {

	@GetMapping("/equipment")
	public String accounting() {
		
		return "manager/equipment";
	}
}
