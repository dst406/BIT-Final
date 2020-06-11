package com.varchar.www.model.service;

import java.util.List;

import com.varchar.www.model.domain.manager.Lecture;
import com.varchar.www.model.domain.manager.LectureRoom;
import com.varchar.www.model.domain.manager.LectureState;
import com.varchar.www.model.domain.manager.LectureSubject;
import com.varchar.www.model.domain.manager.LectureTimeTable;
import com.varchar.www.model.domain.manager.LectureVO;

public interface LectureService {
	
	List<Lecture> getManagerLectureList();
	List<LectureRoom> getLectureRoomList();
	List<LectureSubject> getLectureSubjectList();
	List<LectureState> getLectureStateList();
	void insertLecture(LectureVO lectureVO);
	Lecture getLectureInfo(String lecture_code);

}
