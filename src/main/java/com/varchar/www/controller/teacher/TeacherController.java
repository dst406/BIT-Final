package com.varchar.www.controller.teacher;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.varchar.www.login.AcademyUser;
import com.varchar.www.model.domain.page.Criteria;
import com.varchar.www.model.domain.page.PageDTO;
import com.varchar.www.model.domain.teacher.AttendanceState;
import com.varchar.www.model.domain.teacher.Teacher;
import com.varchar.www.model.service.ApprovalService;
import com.varchar.www.model.service.LectureService;
import com.varchar.www.model.service.ManagerService;
import com.varchar.www.model.service.TeacherService;

@Controller
public class TeacherController {
	
	@Autowired	private ManagerService managerService;
	@Autowired	private TeacherService teacherService;
	@Autowired	private LectureService lectureService;
	@Autowired  private ApprovalService approvalService;
	
	//강사의 메인페이지 입니다.
	@GetMapping("/teacherIndex")
	public String teacherIndex(@AuthenticationPrincipal AcademyUser user ,Model model) {
		model.addAttribute("lectureList", lectureService.getLectureList());
		model.addAttribute("approvalList", approvalService.getApprovalWaitList(user.getUserId()));
		return "main/teacherIndex";
	}
	//원장이 보는 강사목록페이지 입니다.
	@GetMapping("/getManagerTeacherList")
	public String getManagerTeacherList(Criteria cri, Model model) {
		model.addAttribute("teacherList", managerService.getManagerTeacherList(cri, "2"));
		model.addAttribute("managerList", managerService.getManagerInfo("1"));
		model.addAttribute("pageMaker", new PageDTO(cri, teacherService.getTeacherAccount("2")));
		return "teacher/getManagerTeacherList";
	}
	
	//강사가 보는 강사목록 페이지 입니다.
	@GetMapping("/getTeacherList")
	public String getTeacherList(Criteria cri, Model model) {
		model.addAttribute("teacherList", managerService.getManagerTeacherList(cri, "2"));
		model.addAttribute("manager", managerService.getManagerInfo("1"));
		model.addAttribute("pageMaker", new PageDTO(cri, teacherService.getTeacherAccount("2")));
		return "teacher/getTeacherList";
	}
	
	//원장이 강사를 등록하는 페이지 입니다.
	@GetMapping ("/goInsertTeacher")
	public String goInsertTeacher(@ModelAttribute Teacher teacher) {
		return "teacher/insertTeacher";
	}
		
	//원장이 강사를 등록
	@PostMapping("/insertTeacher")
	public String insertTeacher(Teacher teacher) {
		//System.err.println(teacher);
		teacherService.insertTeacher(teacher);
		return "redirect:/getTeacherList";
	}
	
	//원장이 강사를 삭제
	@GetMapping("/deleteTeacher/{userId}")
	public String deleteTeacher(@PathVariable String userId) {
		teacherService.deleteTeacher(userId);
		return "redirect:/getManagerTeacherList";
	}
	
	//원장이 강사의 상세정보를 조회하는 페이지 입니다.
	@GetMapping ("/getManagerTeacherInfo/{userId}")
	public String getManagerTeacherInfo(@PathVariable String userId, Model model) {
		model.addAttribute("teacherInfo",teacherService.getTeacherInfo(userId));
		model.addAttribute("careerList",teacherService.getTeacherCareer(userId));
		return "teacher/getManagerTeacherInfo";
	}
	
	//원장이 보는 강사 출퇴근 기록부 입니다.
	@GetMapping("/getManagerTeacherTimeCard")
	public String getManagerTeacherTimeCard(Criteria cri, Model model) {
		model.addAttribute("getTeacherTimeCard",teacherService.getManagerTeacherTimeCard(cri,"2"));
		model.addAttribute("pageMaker",new PageDTO(cri, teacherService.getManagerTeacherTimdCardAccount("2")));
		model.addAttribute("timeDate", "");
		model.addAttribute("stateName", "전체");
		return "manager/getManagerTeacherTimeCard";
	}
	
	@GetMapping("/manager/attendance/search/{attendanceGoTime}/{attendanceStateName}")
	public String getManageTeacherTimeCardSearch(@PathVariable("attendanceGoTime") String attendanceGoTime, 
			@PathVariable("attendanceStateName") String attendanceStateName, Criteria cri, Model model) {
		model.addAttribute("getTeacherTimeCard", teacherService.getAttendanceType(cri, attendanceStateName, attendanceGoTime));
		model.addAttribute("pageMaker",new PageDTO(cri, teacherService.getAttendanceTypeAccount(attendanceStateName, attendanceGoTime)));
		model.addAttribute("timeDate", attendanceGoTime);
		model.addAttribute("stateName", attendanceStateName);
		return "manager/getManagerTeacherTimeCard";
	}
	
	//강사가 보는 자신의 출퇴근 기록부 페이지 입니다.
	@GetMapping("/getTeacherTimeCard/{userId}")
	public String getTeacherTimeCard(@PathVariable String userId,Criteria cri, Model model) {
		model.addAttribute("getTeacherTimeCard", teacherService.getTeacherTimeCard(cri, userId));
		return "teacher/getTeacherTimeCard";
	}
	
	//강사가 강사의 상세정보를 조회하는 페이지 입니다.
	@GetMapping ("/getTeacherInfo/{userId}")
	public String getTeacherInfo(@PathVariable String userId, Model model) {
		model.addAttribute("teacherInfo",teacherService.getTeacherInfo(userId));
		model.addAttribute("careerList",teacherService.getTeacherCareer(userId));
		return "teacher/getTeacherInfo";
	}
		

	
	//teacherView Test
	@GetMapping("/teacherView")
	public String teacherView() {
		return"teacher/teacherView";
	}
	
	//teacherInfo Test
	@GetMapping("/teacherInfo")
	public String teacherInfo() {
		return"/teacher/teacherInfo";
	}
	
	//teacherInfo Test2
	@GetMapping("/teacherInfo2")
	public String teacherInfo2() {
		return"/teacher/teacherInfo2";
	}
	
	@ModelAttribute("attendanceStateList")
	public List<AttendanceState> getAttendanceState(){
		return teacherService.getAttendanceState();
	}

		
}