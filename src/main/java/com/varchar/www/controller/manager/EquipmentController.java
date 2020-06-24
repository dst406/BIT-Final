package com.varchar.www.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EquipmentController {

	@GetMapping("/equipment")
	public String accounting() {
		
		return "manager/equipment";
	}
}
