package com.varchar.www.controller.record;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.varchar.www.model.service.RecordService;


@Controller
public class RecordController {
	
	@Autowired
	private RecordService recordService;
	
	@GetMapping("/getRecordList")
	public String getRecordList(Model model) {
		model.addAttribute("recordList", recordService.getRecordList());
		
		return "record/recordManagement";
	}
	
	@GetMapping("/recordRegist/{userId}")
	public String recordRegist() {
	
		
		return "record/recordRegist";
	}
	
	@GetMapping("/recordModify/{userId}")
	public String recordModify(@PathVariable String userId, Model model) {
		model.addAttribute("recordInfo", recordService.getStudentRecord(userId));
		
		return "record/recordModify";
	}
}
