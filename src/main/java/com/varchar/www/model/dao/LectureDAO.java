package com.varchar.www.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.varchar.www.model.domain.lecture.Lecture;
import com.varchar.www.model.domain.lecture.LectureRoom;
import com.varchar.www.model.domain.lecture.LectureState;
import com.varchar.www.model.domain.lecture.LectureSubject;
import com.varchar.www.model.domain.lecture.LectureVO;

@Mapper
public interface LectureDAO {
	
	List<Lecture> getManagerLectureList();
	List<Lecture> getTeacherLectureList();
	List<LectureRoom> getLectureRoomList();
	List<LectureSubject> getLectureSubjectList();
	List<LectureState> getLectureStateList();
	void insertLecture(LectureVO lectureVO);
	Lecture getLectureInfo(String lecture_code);
	void deleteLecture(String lectureCode);

}
