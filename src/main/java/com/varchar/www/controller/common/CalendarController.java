package com.varchar.www.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalendarController {
	
	@GetMapping("/calendar")
	public String calendar() {
		return "/util/calendar";
	}
	
	@GetMapping("/calendarDefault")
	public String calendarDefault() {
		return "/util/calendarDefaultForm";
	}
	
	@GetMapping("/schedule")
	public String schedule() {
			
		return "/util/schedule";
	}
}
