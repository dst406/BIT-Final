package com.varchar.www.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varchar.www.model.dao.LectureDAO;
import com.varchar.www.model.domain.lecture.Lecture;
import com.varchar.www.model.domain.lecture.LectureRoom;
import com.varchar.www.model.domain.lecture.LectureState;
import com.varchar.www.model.domain.lecture.LectureSubject;
import com.varchar.www.model.domain.lecture.LectureVO;
import com.varchar.www.model.service.LectureService;

@Service
public class LectureServiceImpl implements LectureService{
	
	@Autowired
	private LectureDAO lecturedao;

	@Override
	public List<Lecture> getManagerLectureList() {
		return lecturedao.getManagerLectureList();
	}
	
	@Override
	public List<Lecture> getTeacherLectureList() {
		return lecturedao.getTeacherLectureList();
	}

	@Override
	public List<LectureRoom> getLectureRoomList() {
		return lecturedao.getLectureRoomList();
	}

	@Override
	public List<LectureSubject> getLectureSubjectList() {
		return lecturedao.getLectureSubjectList();
	}

	@Override
	public List<LectureState> getLectureStateList() {
		return lecturedao.getLectureStateList();
	}

	@Override
	public void insertLecture(LectureVO lectureVO) {
		lecturedao.insertLecture(lectureVO);
	}

	@Override
	public Lecture getLectureInfo(String lecture_code) {
		return lecturedao.getLectureInfo(lecture_code);
	}

	@Override
	public void deleteLecture(String lectureCode) {
		lecturedao.deleteLecture(lectureCode);
		
	}

	

}
