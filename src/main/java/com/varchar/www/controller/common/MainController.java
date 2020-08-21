package com.varchar.www.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

	@GetMapping("/")
	public String mainIndex() {
		return "company/main/company";
	}
	
	@GetMapping("/intro")
	public String portfolio() {
		return "portfolio/intro";
	}
	
	@GetMapping("/{auth}/getNavbar")
	public String moveJobLeftNavBar(@PathVariable String auth) {
		return "layout/"+auth+"NavBar :: leftNavBar";
	}
	
	
	
}
