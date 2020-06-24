package com.varchar.www.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategotyController {

	@GetMapping("/category")
	public String accounting() {
		
		return "manager/category";
	}
	
	public String insertVariableCategory() {
		
		return "manager/category";
	}
	
	public String getVariableCategory() {
		
		return "manager/category";
	}
	
	public String updateVariableCategory() {
	
	return "manager/category";
	}
	
	public String deleteVariableCategory() {
	
	return "manager/category";
	}
	
	public String insertFixedCategory() {
	
	return "manager/category";
	}
	
	public String getFixedCategory() {
		
	return "manager/category";
	}
	
	public String updateFixedCategory() {
		
	return "manager/category";
	}
	
	public String deleteFixedCategory() {
		
	return "manager/category";
	}
	
	
}
