package com.varchar.www.controller.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecordController {
	//record
		@GetMapping("/recordManagement")
		public String recordManagement() {
			return "/record/recordManagement";
		}
		
		@GetMapping("/recordModify")
		public String recordModify() {
			return "/record/recordModify";
		}
		
		@GetMapping("/recordRegist")
		public String recordRegist() {
			return "/record/recordRegist";
		}
}
