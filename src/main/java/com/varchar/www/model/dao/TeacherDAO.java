package com.varchar.www.model.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.varchar.www.model.domain.manager.Attendance;
import com.varchar.www.model.domain.manager.CareerVO;
import com.varchar.www.model.domain.page.Criteria;
import com.varchar.www.model.domain.teacher.AttendanceState;
import com.varchar.www.model.domain.teacher.Teacher;
import com.varchar.www.model.domain.teacher.TeacherVO;

@Mapper
public interface TeacherDAO {
	
	void insertTeacher(Teacher teacher); //원장의 강사등록 - user테이블 들어갈부분
	void insertCareer(Teacher teacher); //원장의 강사등록 - career테이블 들어갈부분
	void deleteTeacher(String userId);//원장이 강사를 삭제
	List<Teacher> getTeacherList(String authority_code);
	TeacherVO getTeacherInfo(String userId);
	List<CareerVO> getTeacherCareer(String userId);
	List<Attendance> getTeacherTimeCard(@Param("cri") Criteria cri,@Param("userId") String userId);
	
	List<Attendance> getManagerTeacherTimeCard(@Param("cri")Criteria cri, @Param("authorityCode") String authorityCode);
	List<Attendance> getTeacherTimeCardByDate(@Param("cri")Criteria cri, @Param("attendanceGoTime") String attendanceGoTime);
	List<Attendance> getAttendanceType(@Param("cri") Criteria cri,@Param("attendanceStateName") String attendanceStateName);
	List<Attendance> getAttendanceSearch(@Param("cri") Criteria cri,
			@Param("attendanceStateName") String attendanceStateName,
			@Param("attendanceGoTime") String attendanceGoTime);
	
	List<AttendanceState> getAttendanceState();
	
	int getTeacherAccount(String authorityCode);
	int getManagerTeacherTimdCardAccount(String authorityCode);
	int getAttendanceTypeAccount(String attendanceStateName);
	int getTeacherTimeCardByDateAccount(String attendanceGoTime);
	int getAttendanceSearchAccount(@Param("attendanceStateName") String attendanceStateName,
			@Param("attendanceGoTime") String attendanceGoTime);
	int getTeacherTimeCardAccount(String userId);
}
