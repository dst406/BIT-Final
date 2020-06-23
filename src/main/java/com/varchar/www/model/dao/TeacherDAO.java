package com.varchar.www.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.varchar.www.model.domain.manager.Attendance;
import com.varchar.www.model.domain.manager.CareerVO;
import com.varchar.www.model.domain.teacher.TeacherVO;

@Mapper
public interface TeacherDAO {
	
	void insertTeacher(TeacherVO teacher);
	void insertCareer(CareerVO career);
	void deleteTeacher(String userId);

	TeacherVO getTeacherInfo(String userId);
	List<CareerVO> getTeacherCareer(String userId);
	List<Attendance> getTeacherTimeCard(String authorityCode);
	List<Attendance> getManagerTeacherTimeCard(String authorityCode);
	List<Attendance> getTeacherTimeCardByDate(String attendanceGoTime);
	List<Attendance> getgetAttendanceType(String attendanceStateName);

}
