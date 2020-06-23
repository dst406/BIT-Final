package com.varchar.www.controller.lecture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.varchar.www.model.domain.lecture.LectureRoom;
import com.varchar.www.model.domain.lecture.LectureState;
import com.varchar.www.model.domain.lecture.LectureSubject;
import com.varchar.www.model.domain.lecture.LectureVO;
import com.varchar.www.model.domain.manager.Season;
import com.varchar.www.model.domain.teacher.Teacher;
import com.varchar.www.model.service.LectureService;
import com.varchar.www.model.service.ManagerService;

@Controller
public class LectureController {
	
	@Autowired
	private LectureService lectureService;
	
	@Autowired
	private ManagerService managerService;
	
	// 원장이 보는 강의목록
	@GetMapping("/getManagerLectureList")
	public String getManagerLectureList(Model model) {
		model.addAttribute("lectureList", lectureService.getManagerLectureList());
		return "manager/getManagerLectureList";
	}
	
	//강사가 보는 강의목록
	@GetMapping("/getTeacehrLectureList")
	public String getTeacherLectureList(Model model) {
		model.addAttribute("lectureList",lectureService.getTeacherLectureList());
		return "teacher/getTeacherLectureList";
	}
	
	// 원장이 하는 강의등록페이지(강사는 불가능합니다.)
	@GetMapping("/goInsertLecture")
	public String goInsertLecture(@ModelAttribute LectureVO lectureVO) {
		return "lecture/insertLecture";
	}
	
	//강의 조회 페이지 입니다.
	@GetMapping("/getLectureInfo/{lecture_code}")
	public String getLectureInfo(@PathVariable String lecture_code, Model model) {
		model.addAttribute("lecture", lectureService.getLectureInfo(lecture_code));
		return "lecture/getLectureInfo";
	}
	
	//원장이 하는 강의등록
	@PostMapping("/insertLecture")
	public String insertLecture(LectureVO lectureVO) {
		lectureService.insertLecture(lectureVO);
		return "redirect:/getManagerLectureList";
	}
	
	//원장이 강의를 삭제
	@GetMapping("/deleteLecture/{lectureCode}")
	public String deleteLecture(@PathVariable String lectureCode) {
		lectureService.deleteLecture(lectureCode);
		return"redirect:/getManagerLectureList";
	}
	
	//원장이조희할 수 있는 강의실 목록
	@GetMapping("/getManagerLectureRoomList")
	public String getManagerLectureRoomList() {
		return "lecture/getManagerLectureRoomList";
	}
	
	//렉쳐뷰 테스트
	@GetMapping("/lectureView")
	public String lectureView() {
		return "teacher/lectureView";
	}
	
	
	@ModelAttribute("teacherList")
	public List<Teacher> getTeacherName(){
		return managerService.getTeacherList("2");
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
	
	
	
	
}