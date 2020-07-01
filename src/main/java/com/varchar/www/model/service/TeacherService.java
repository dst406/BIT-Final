package com.varchar.www.model.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.varchar.www.model.domain.manager.Attendance;
import com.varchar.www.model.domain.manager.CareerVO;
import com.varchar.www.model.domain.page.Criteria;
import com.varchar.www.model.domain.teacher.AttendanceState;
import com.varchar.www.model.domain.teacher.Teacher;
import com.varchar.www.model.domain.teacher.TeacherVO;

public interface TeacherService {

	TeacherVO getTeacherInfo(String userId);
	
	List<Teacher> getTeacherList(String authority_code);
	List<CareerVO> getTeacherCareer(String userId);
	List<Attendance> getTeacherTimeCard(Criteria cri, String userId);
	//List<Attendance> getTeacherTimeCardByDate(String attendanceGoTime);
	List<Attendance> getManagerTeacherTimeCard(Criteria cri, String authorityCode);
	List<Attendance> getAttendanceType (Criteria cri,String attendanceStateName, String attendanceGoTime);
	List<AttendanceState> getAttendanceState();
	
	void uploadTeacherImage(MultipartFile imgFile);
	void insertTeacher(Teacher teacher);
	void deleteTeacher(String userId);
	
	int getTeacherAccount(String authorityCode);
	int getManagerTeacherTimdCardAccount(String authorityCode);
	int getAttendanceTypeAccount(String attendanceStateName,String attendanceGoTime);

}
