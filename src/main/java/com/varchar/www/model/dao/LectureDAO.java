package com.varchar.www.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.varchar.www.model.domain.lecture.Lecture;
import com.varchar.www.model.domain.lecture.LectureRoom;
import com.varchar.www.model.domain.lecture.LectureState;
import com.varchar.www.model.domain.lecture.LectureStatus;
import com.varchar.www.model.domain.lecture.LectureSubject;
import com.varchar.www.model.domain.lecture.LectureTimeTable;
import com.varchar.www.model.domain.lecture.LectureVO;
import com.varchar.www.model.domain.student.Student;

@Mapper
public interface LectureDAO {
	
	List<Lecture> getManagerLectureList();
	List<Lecture> getTeacherLectureList(@Param("userId") String userId);
	List<LectureRoom> getLectureRoomList();
	List<LectureSubject> getLectureSubjectList();
	List<LectureState> getLectureStateList();
	void insertLecture(LectureVO lectureVO);
	Lecture getLectureInfo(String lecture_code);
	void deleteLecture(String lectureCode);
	List<LectureTimeTable> getMangerTimeTableList();
	List<Student> getStudentNoLecture();
	List<Student> getStudentLecture(String lectureCode);
	void postLectureStudent(@Param("userId") String userId,@Param("lectureCode") String lectureCode);
	void deleteLectureStudent(@Param("userId") String userId,@Param("lectureCode") String lectureCode);
	void postLectureTimeTable(LectureTimeTable lectureTimeTable);
	
	List<LectureStatus> getLectureStatusChart();
	List<Lecture> getLectureList();

}
