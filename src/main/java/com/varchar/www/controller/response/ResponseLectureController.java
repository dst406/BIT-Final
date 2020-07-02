package com.varchar.www.controller.response;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.varchar.www.model.domain.lecture.Lecture;
import com.varchar.www.model.domain.lecture.LectureStatus;
import com.varchar.www.model.domain.lecture.LectureTimeTable;
import com.varchar.www.model.service.LectureService;

@RestController
public class ResponseLectureController {
	
	@Autowired LectureService lectureService;
	
	@PostMapping("/lecture/student/add/{lectureCode}")
	public void postLectureStudent(@RequestBody(required = true) String[] userIds, @PathVariable String lectureCode) {
		for(String str : userIds) {
			System.err.println(str);
			lectureService.postLectureStudent(str, lectureCode);
		}
	}
	
	@DeleteMapping("/lecture/student/delete/{lectureCode}")
	public void deleteLectureStudent(@RequestBody(required = true) String[] userIds, @PathVariable String lectureCode) {
		for(String str : userIds) {
			System.err.println(str);
			lectureService.deleteLectureStudent(str, lectureCode);
		}
	}
	
	@GetMapping("/lecture/chart")
	public List<LectureStatus> getLectureStatusChart(){
		return lectureService.getLectureStatusChart();
	}
	
	@PostMapping("/manager/lecture/room/add")
	public void postLectureTimeTable(@RequestBody LectureTimeTable lectureTimeTable) {
		System.err.println(lectureTimeTable);
		lectureService.postLectureTimeTable(lectureTimeTable);
	}
	
	@PutMapping("/manager/lecture/update")
	public void putLecture(@RequestBody Lecture lecture) {
		System.err.println(lecture);
		lectureService.putLecture(lecture);
	}
	
}