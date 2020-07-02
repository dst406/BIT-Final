package com.varchar.www.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varchar.www.model.dao.LectureDAO;
import com.varchar.www.model.domain.lecture.Lecture;
import com.varchar.www.model.domain.lecture.LectureRoom;
import com.varchar.www.model.domain.lecture.LectureState;
import com.varchar.www.model.domain.lecture.LectureStatus;
import com.varchar.www.model.domain.lecture.LectureSubject;
import com.varchar.www.model.domain.lecture.LectureTimeTable;
import com.varchar.www.model.domain.lecture.LectureVO;
import com.varchar.www.model.domain.student.Student;
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
	public List<Lecture> getTeacherLectureList(String userId) {
		return lecturedao.getTeacherLectureList(userId);
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

	@Override
	public List<LectureTimeTable> getMangerTimeTableList() {
		return lecturedao.getMangerTimeTableList();
	}

	@Override
	public List<Student> getStudentNoLecture() {
		return lecturedao.getStudentNoLecture();
	}

	@Override
	public List<Student> getStudentLecture(String lectureCode) {
		return lecturedao.getStudentLecture(lectureCode);
	}

	@Override
	public void postLectureStudent(String userId, String lectureCode) {
		lecturedao.postLectureStudent(userId, lectureCode);
		
	}

	@Override
	public void deleteLectureStudent(String userId, String lectureCode) {
		lecturedao.deleteLectureStudent(userId, lectureCode);
		
	}

	@Override
	public List<LectureStatus> getLectureStatusChart() {
		return lecturedao.getLectureStatusChart();
	}

	@Override
	public List<Lecture> getLectureList() {
		return lecturedao.getLectureList();
	}

	@Override
	public void postLectureTimeTable(LectureTimeTable lectureTimeTable) {
		lecturedao.postLectureTimeTable(lectureTimeTable);
		
	}

	@Override
	public List<Lecture> getMyLectureList(String userId) {
		return lecturedao.getMyLectureList(userId);
	}

	@Override
	public List<Lecture> getLectureListByState(String lectureState) {
		return lecturedao.getLectureListByState(lectureState);
	}

	@Override
	public void putLecture(Lecture lecture) {
		lecturedao.putLecture(lecture);
		
	}

	@Override
	public List<Lecture> getLectureListNoFull() {
		return lecturedao.getLectureListNoFull();
	}

	

}
