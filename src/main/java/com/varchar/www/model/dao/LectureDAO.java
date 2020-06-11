package com.varchar.www.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.varchar.www.model.domain.manager.Lecture;
import com.varchar.www.model.domain.manager.LectureRoom;
import com.varchar.www.model.domain.manager.LectureState;
import com.varchar.www.model.domain.manager.LectureSubject;
import com.varchar.www.model.domain.manager.LectureTimeTable;
import com.varchar.www.model.domain.manager.LectureVO;

@Mapper
public interface LectureDAO {
	
	List<Lecture> getManagerLectureList();
	List<LectureRoom> getLectureRoomList();
	List<LectureSubject> getLectureSubjectList();
	List<LectureState> getLectureStateList();
	void insertLecture(LectureVO lectureVO);
	Lecture getLectureInfo(String lecture_code);

}
