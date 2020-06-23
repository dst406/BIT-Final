package com.varchar.www.model.service;

import java.util.List;

import com.varchar.www.model.domain.manager.Attendance;
import com.varchar.www.model.domain.manager.CareerVO;
import com.varchar.www.model.domain.teacher.Teacher;
import com.varchar.www.model.domain.teacher.TeacherVO;

public interface TeacherService {
	
	void insertTeacher(Teacher teacher);
	void deleteTeacher(String userId);
	TeacherVO getTeacherInfo(String userId);
	List<CareerVO> getTeacherCareer(String userId);
	List<Attendance> getTeacherTimeCard(String authorityCode);
	List<Attendance> getManagerTeacherTimeCard(String authorityCode);
	List<Attendance> getTeacherTimeCardByDate(String attendanceGoTime);
	List<Attendance> getAttendanceType (String attendanceStateName);

}
