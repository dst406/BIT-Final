package com.varchar.www.controller.lecture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.varchar.www.model.domain.manager.Lecture;
import com.varchar.www.model.domain.manager.LectureRoom;
import com.varchar.www.model.domain.manager.LectureState;
import com.varchar.www.model.domain.manager.LectureSubject;
import com.varchar.www.model.domain.manager.LectureTimeTable;
import com.varchar.www.model.domain.manager.LectureVO;
import com.varchar.www.model.domain.manager.Season;
import com.varchar.www.model.domain.manager.Teacher;
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
	
	// 원장이 하는 강의등록페이지(강사는 불가능합니다.)
	@GetMapping("/goInsertLecture")
	public String goInsertLecture(@ModelAttribute LectureVO lectureVO) {
		return "lecture/insertLecture";
	}
	
	//강의 조회 페이지 입니다.
	@GetMapping("/getLectureInfo/{lecture_code}")
	public String getLectureInfo(@PathVariable String lecture_code, Model model) {
		model.addAttribute("lectureInfo", lectureService.getLectureInfo(lecture_code));
		return "lecture/getLectureInfo";
	}
	
	//원장이 하는 강의등록
	@PostMapping("/insertLecture")
	public String insertLecture(LectureVO lectureVO) {
		lectureService.insertLecture(lectureVO);
		return "redirect:/getManagerLectureList";
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