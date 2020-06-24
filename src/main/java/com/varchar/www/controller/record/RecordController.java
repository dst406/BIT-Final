package com.varchar.www.controller.record;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.varchar.www.model.domain.record.Record;
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
	
	@GetMapping("/recordRegist")
	public String recordRegist(@ModelAttribute Record record) {
		
		
		return "record/recordRegist";
	}
	
	@PostMapping("/insertRecord")
	public String insertStudent(@ModelAttribute Record record) {
		 recordService.insertRecord(record);
		return "redirect:/registComplete";
	}
	
	@GetMapping("/recordModify/{userId}")
	public String recordModify(@PathVariable String userId, Model model) {
		model.addAttribute("recordInfo", recordService.getStudentRecord(userId));
		
		return "record/recordModify";
	}
	
	@GetMapping("/deleteRecord/{userId}")
	public String rdeleteRecord(@PathVariable String userId, Model model) {
		
		
		return "record/recordModify";
	}
}
