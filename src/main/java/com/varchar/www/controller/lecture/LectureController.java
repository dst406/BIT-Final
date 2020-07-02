package com.varchar.www.controller.lecture;

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
import com.varchar.www.model.domain.lecture.LectureRoom;
import com.varchar.www.model.domain.lecture.LectureState;
import com.varchar.www.model.domain.lecture.LectureSubject;
import com.varchar.www.model.domain.lecture.LectureVO;
import com.varchar.www.model.domain.manager.Season;
import com.varchar.www.model.domain.page.Criteria;
import com.varchar.www.model.domain.student.Student;
import com.varchar.www.model.domain.teacher.Teacher;
import com.varchar.www.model.service.LectureService;
import com.varchar.www.model.service.ManagerService;
import com.varchar.www.model.service.TeacherService;

@Controller
public class LectureController {
	
	@Autowired private LectureService lectureService;
	@Autowired private ManagerService managerService;
	@Autowired private TeacherService teacherService;
	
	// 원장이 보는 강의목록 페이지
	@GetMapping("/manager/getManagerLectureList")
	public String getManagerLectureList(Model model) {
		model.addAttribute("lectureList", lectureService.getManagerLectureList());
		return "lecture/getManagerLectureList";
	}
	
	//강사가 자신이 강의중인 강의목록을 보는 페이지
	@GetMapping("/teacher/getTeacherLectureList")
	public String getTeacherLectureList(Model model, @AuthenticationPrincipal AcademyUser user) {
		model.addAttribute("lectureList",lectureService.getTeacherLectureList(user.getUserId()));
		return "/lecture/getTeacherLectureList";
	}
	
	//강사가 보는 모든 강의목록 페이지
	@GetMapping("/teacher/getLectureList")
	public String getLectureList(Model model) {
		model.addAttribute("lectureList",lectureService.getLectureList());
		model.addAttribute("lectureState", "전체");
		return "/lecture/getLectureList";
	}
	
	//원장이 강의를 등록하는 페이지 (강사는 불가능)
	@GetMapping("/manager/goInsertLecture")
	public String goInsertLecture(@ModelAttribute LectureVO lectureVO) {
		return "lecture/insertLecture";
	}
	
	//원장이 하는 강의등록
	@PostMapping("/insertLecture")
	public String insertLecture(LectureVO lectureVO) {
		lectureService.insertLecture(lectureVO);
		return "redirect:/manager/getManagerLectureList";
	}
	
	//강의 조회 페이지 입니다.
	@GetMapping("/getLectureInfo/{lecture_code}")
	public String getLectureInfo(@PathVariable String lecture_code, Model model) {
		model.addAttribute("lecture", lectureService.getLectureInfo(lecture_code));
		return "lecture/getLectureInfo";
	}
	
	//원장이 강의를 삭제
	@GetMapping("/manager/deleteLecture/{lectureCode}")
	public String deleteLecture(@PathVariable String lectureCode) {
		lectureService.deleteLecture(lectureCode);
		return"redirect:/manager/getManagerLectureList";
	}
	
	//원장이조희할 수 있는 강의실 목록 페이지
	@GetMapping("/manager/getManagerLectureRoomList")
	public String getManagerLectureRoomList(Model model) {
		model.addAttribute("getTimeTableList",lectureService.getMangerTimeTableList());
		model.addAttribute("lectureList", lectureService.getLectureList());
		return "lecture/getManagerLectureRoomList";
	}
	
	//강사가 조희할 수 있는 강의실 목록 페이지
	@GetMapping("/teacher/getTeacherLectureRoomList")
	public String getTeacherLectureRoomList(Model model) {
		model.addAttribute("getTimeTableList",lectureService.getMangerTimeTableList());
		return "lecture/getTeacherLectureRoomList";
	}
	
	//강의 학생
	@GetMapping("/goLectureMember/{lectureCode}")
	public String goLectureMember(@PathVariable String lectureCode, Model model) {
		model.addAttribute("lectureStudent", lectureService.getStudentLecture(lectureCode));
		model.addAttribute("lectureCode", lectureCode);
		return "lecture/goLectureMember";
	}
	
	//선생 -> 강의 상태별 검색
	@GetMapping("/teacher/getLectureListByState/{lectureState}")
	public String getLectureListByState(@PathVariable String lectureState, Model model) {
		if(!lectureState.equals("전체")) {
			model.addAttribute("lectureList", lectureService.getLectureListByState(lectureState));
			model.addAttribute("lectureState", lectureState);
			return "lecture/getLectureList";			
		}else {
			return "redirect:/teacher/getLectureList";
		}
		
	}
	
	@ModelAttribute("studentNoLecture")
	public List<Student> getStudentNoLecture(){
		return lectureService.getStudentNoLecture();
	}
	
	@ModelAttribute("teacherList")
	public List<Teacher> getTeacherName(Criteria cri){
		cri.setAmount(teacherService.getTeacherAccount("2"));
		return managerService.getManagerTeacherList(cri, "2");
	}
	
	@ModelAttribute("seasonList")
	public List<Season> seasonList(){
		return managerService.getSeasonList();
	}
	
	@ModelAttribute("lectureRoomList")
	public List<LectureRoom> lectureRoomList(){
		return lectureService.getLectureRoomList();
	}
	
	@ModelAttribute("lectureSubjectList")
	public List<LectureSubject> lectureSubjectList(){
		return lectureService.getLectureSubjectList();
	}
	
	@ModelAttribute("lectureStateList")
	public List<LectureState> lectureStateList(){
		return lectureService.getLectureStateList();
	}
	
	
	@ModelAttribute("teacherList")
	public List<Teacher> getTeacherListAll(){
		return teacherService.getTeacherListAll();
	}
}