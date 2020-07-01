package com.varchar.www.controller.student;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.varchar.www.login.AcademyUser;
import com.varchar.www.model.domain.page.Criteria;
import com.varchar.www.model.domain.page.PageDTO;
import com.varchar.www.model.domain.student.Student;
import com.varchar.www.model.service.RecordService;
import com.varchar.www.model.service.StudentService;


@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private RecordService recordService;
	
	//student
	
		@PostMapping("/teacher/insertStudent")
		public String insertStudent(@ModelAttribute Student student, @AuthenticationPrincipal AcademyUser user) {
			student.setAuthorityCode( user.getUserId() );
			student.setUserPassword( new BCryptPasswordEncoder().encode( student.getUserPassword() ) );
			studentService.insertStudent(student);	
			return "redirect:/teacher/registComplete";
		}
		
		@PostMapping("/teacher/modifyStudent")
		public String modifyStudent(@ModelAttribute Student student) {

			studentService.modifyStudent(student);
			return "redirect:/teacher/registComplete";
		}

		@RequestMapping("/teacher/deleteStudent/{userId}")
		public String deleteStudent(@PathVariable String userId) {
			studentService.deleteStudent(userId);
			return "redirect:/teacher/getStudentList";
		}
		
		@GetMapping("/teacher/getStudentList")
		public String getStudentList(Criteria cri, Model model, @AuthenticationPrincipal AcademyUser user) {
			model.addAttribute("studentList", studentService.getStudentList(cri, user.getAuthorityCode()));
			model.addAttribute("pageMaker", new PageDTO(cri, studentService.getStudentAccount("3")));
			return "student/studentList";
		}	
		
		@GetMapping("/teacher/getStudentListTeacher")
		public String getStudentListTeacher(Criteria cri, Model model) {
			model.addAttribute("studentList", studentService.getStudentList(cri, "3"));
			model.addAttribute("pageMaker", new PageDTO(cri, studentService.getStudentAccount("3")));
			return "student/studentListTeacher";
		}
		
		@GetMapping("/teacher/studentModify/{userId}")
		public String studentModify(@PathVariable String userId, Model model) {
			model.addAttribute("studentInfo", studentService.getStudentInfo(userId) );
			return "student/studentModify";
		}	
		
		@GetMapping("/teacher/registComplete")
		public String registComplete() {
			
			return "util/registComplete";
		}	
		
		@GetMapping("/teacher/studentRegist")
		public String studentRegist(@ModelAttribute Student student) {
			
			return "student/studentRegist";
		}	
	
		@GetMapping("/student/studentMain")
		public String studentMain() {
		
			return "student/studentMain";
		}
		
		@GetMapping("/teacher/getStudentInfo/{userId}")
		public String getStudentInfo(@PathVariable String userId, Model model) {
			model.addAttribute("studentInfo", studentService.getStudentInfo(userId));
			model.addAttribute("recordInfo", recordService.getStudentRecord(userId));
			return "student/studentInfo";
		}
}
