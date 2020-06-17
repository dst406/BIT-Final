package com.varchar.www.controller.student;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.varchar.www.model.domain.student.Student;
import com.varchar.www.model.service.StudentService;


@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	//student
	
		@PostMapping("/insertStudent")
		public String insertStudent(@ModelAttribute Student student) {
			studentService.insertStudent(student);	
			
			 
			return "redirect:/registComplete";
		}
		
		@PostMapping("/modifyStudent")
		public String modifyStudent(@ModelAttribute Student student) {

			studentService.modifyStudent(student);
			return "redirect:/registComplete";
		}

		@RequestMapping("/deleteStudent/{userId}")
		public String deleteStudent(@PathVariable String userId) {
			studentService.deleteStudent(userId);
			return "redirect:/getStudentList";
		}
		
		@GetMapping("/getStudentList")
		public String getStudentList(Model model) {
			model.addAttribute("studentList", studentService.getStudentList("3"));
			return "student/studentList";
		}	
		
		@GetMapping("/getStudentListTeacher")
		public String getStudentListManager(Model model) {
			model.addAttribute("studentList", studentService.getStudentList("3"));
			return "student/studentListTeacher";
		}
		
		@GetMapping("/studentModify/{userId}")
		public String studentModify(@PathVariable String userId, Model model) {
			model.addAttribute("studentInfo", studentService.getStudentInfo(userId) );
			return "/student/studentModify";
		}	
		
		@GetMapping("/registComplete")
		public String registComplete() {
			
			return "util/registComplete";
		}	
		
		@GetMapping("/studentRegist")
		public String studentRegist(@ModelAttribute Student student) {
			
			return "student/studentRegist";
		}	
	
		@GetMapping("/studentMain")
		public String studentMain() {
		
			return "student/studentMain";
		}
		
		@GetMapping("/getStudentInfo/{userId}")
		public String getStudentInfo(@PathVariable String userId, Model model) {
			model.addAttribute("studentInfo", studentService.getStudentInfo(userId));
			return "student/studentInfo";
		}
}
