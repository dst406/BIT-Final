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
	
	@GetMapping("/teacher/getRecordList")
	public String getRecordList(Model model) {
		model.addAttribute("recordList", recordService.getRecordList());
		
		return "record/recordManagement";
	}
	
	@GetMapping("/teacher/recordRegist")
	public String recordRegist(@ModelAttribute Record record) {
		
		
		return "record/recordRegist";
	}
	
	@PostMapping("/teacher/insertRecord")
	public String insertStudent(@ModelAttribute Record record) {
		 recordService.insertRecord(record);
		return "redirect:/registComplete";
	}
	
	@GetMapping("/teacher/recordModify/{userId}")
	public String recordModify(@PathVariable String userId, Model model) {
		model.addAttribute("recordInfo", recordService.getStudentRecord(userId));
		
		return "record/recordModify";
	}
	
	@GetMapping("/teacher/deleteRecord/{recordNo}")
	public String rdeleteRecord(@PathVariable String recordNo, Model model) {
		recordService.deleteRecord(recordNo);
		
		return "record/recordManagement";
	}
}
