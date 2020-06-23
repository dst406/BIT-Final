package com.varchar.www.model.service;

import java.util.List;

import com.varchar.www.model.domain.lecture.Lecture;
import com.varchar.www.model.domain.lecture.LectureRoom;
import com.varchar.www.model.domain.lecture.LectureState;
import com.varchar.www.model.domain.lecture.LectureSubject;
import com.varchar.www.model.domain.lecture.LectureVO;

public interface LectureService {
	
	List<Lecture> getManagerLectureList();
	List<Lecture> getTeacherLectureList();
	List<LectureRoom> getLectureRoomList();
	List<LectureSubject> getLectureSubjectList();
	List<LectureState> getLectureStateList();
	Lecture getLectureInfo(String lecture_code);
	void insertLecture(LectureVO lectureVO);
	//void updateLecture(LectureVO lectureVO);
	void deleteLecture(String lectureCode);

}
