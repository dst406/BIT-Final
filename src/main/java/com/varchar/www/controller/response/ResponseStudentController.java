package com.varchar.www.controller.response;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.varchar.www.model.service.StudentService;


@RestController
//@RequestMapping("/student")

public class ResponseStudentController {
	
	@Autowired 
	private StudentService studentService;
	
		@PostMapping("/student/image/upload")
		public void putStudentImage(@RequestBody MultipartFile imgFile) {
			System.out.println("rest Cont"+imgFile.getName().toString());
			studentService.uploadStudentImage(imgFile);
		}
		
		
}
