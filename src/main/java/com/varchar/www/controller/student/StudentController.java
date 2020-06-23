package com.varchar.www.controller.student;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


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

		@PostMapping("/deleteStudent")
		public String deleteStudent(String user_id) {
			
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
		
		@GetMapping("/studentModify/{user_id}")
		public String studentModify(@PathVariable String user_id, Model model) {
			model.addAttribute("studentInfo", studentService.getStudentInfo(user_id) );
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
		
		@GetMapping("/getStudentInfo/{user_id}")
		public String getStudentInfo(@PathVariable String user_id, Model model) {
			model.addAttribute("studentInfo", studentService.getStudentInfo(user_id));
			return "student/studentInfo";
		}
}
