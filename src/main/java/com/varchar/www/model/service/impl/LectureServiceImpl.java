package com.varchar.www.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varchar.www.model.dao.LectureDAO;
import com.varchar.www.model.domain.manager.Lecture;
import com.varchar.www.model.domain.manager.LectureRoom;
import com.varchar.www.model.domain.manager.LectureState;
import com.varchar.www.model.domain.manager.LectureSubject;
import com.varchar.www.model.domain.manager.LectureTimeTable;
import com.varchar.www.model.domain.manager.LectureVO;
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

}
