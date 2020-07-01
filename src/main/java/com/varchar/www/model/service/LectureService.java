package com.varchar.www.model.service;

import java.util.List;

import com.varchar.www.model.domain.lecture.Lecture;
import com.varchar.www.model.domain.lecture.LectureRoom;
import com.varchar.www.model.domain.lecture.LectureState;
import com.varchar.www.model.domain.lecture.LectureStatus;
import com.varchar.www.model.domain.lecture.LectureSubject;
import com.varchar.www.model.domain.lecture.LectureTimeTable;
import com.varchar.www.model.domain.lecture.LectureVO;
import com.varchar.www.model.domain.student.Student;

public interface LectureService {
	
	List<Lecture> getManagerLectureList();
	List<Lecture> getTeacherLectureList(String userId);
	List<LectureRoom> getLectureRoomList();
	List<LectureSubject> getLectureSubjectList();
	List<LectureState> getLectureStateList();
	Lecture getLectureInfo(String lecture_code);
	void insertLecture(LectureVO lectureVO);
	//void updateLecture(LectureVO lectureVO);
	void deleteLecture(String lectureCode);
	List<LectureTimeTable> getMangerTimeTableList();
	List<Student> getStudentNoLecture();
	List<Student> getStudentLecture(String lectureCode);
	
	List<LectureStatus> getLectureStatusChart();
	
	void postLectureStudent(String userId, String lectureCode);
	void deleteLectureStudent(String userId, String lectureCode);
	
	void postLectureTimeTable(LectureTimeTable lectureTimeTable);
	
	List<Lecture> getLectureList();
	List<Lecture> getMyLectureList(String userId);
	List<Lecture> getLectureListByState(String lectureState);
	
}
