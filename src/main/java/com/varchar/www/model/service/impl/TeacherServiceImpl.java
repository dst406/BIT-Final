package com.varchar.www.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varchar.www.model.dao.TeacherDAO;
import com.varchar.www.model.domain.manager.Attendance;
import com.varchar.www.model.domain.manager.CareerVO;
import com.varchar.www.model.domain.teacher.Teacher;
import com.varchar.www.model.domain.teacher.TeacherVO;
import com.varchar.www.model.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	private TeacherDAO teacherdao;
	
	//강사 등록
	@Override
	public void insertTeacher(Teacher teacher) {
		//객체에 정보를 각각 담아서 전달
		TeacherVO teacherVO = new TeacherVO();
		teacherVO.setUserId(teacher.getUserId());
		teacherVO.setAuthorityCode("2");
		teacherVO.setUserPw("111111");
		teacherVO.setUserName(teacher.getUserName());
		teacherVO.setUserBirth(teacher.getUserBirth());
		teacherVO.setUserAddress(teacher.getUserAddress());
		teacherVO.setUserEmail(teacher.getUserEmail());
		teacherVO.setUserTel(teacher.getUserTel());
		teacherVO.setUserRemark(teacher.getUserRemark());
		teacherdao.insertTeacher(teacherVO);
		//객체에 정보를 각각 담아서 전달
		CareerVO careerVO = new CareerVO();
		careerVO.setAcademicBackGround(teacher.getAcademicBackGround());
		careerVO.setCareerContent(teacher.getCareerContent());
		careerVO.setCareerLocation(teacher.getCareerLocation());
		careerVO.setCareerPeriod(teacher.getCareerPeriod());
		careerVO.setUserId(teacher.getUserId());
		teacherdao.insertCareer(careerVO);
	}
	
	//강사정보 조회
	@Override
	public TeacherVO getTeacherInfo(String userId) {
		return teacherdao.getTeacherInfo(userId);
	}

	
	@Override
	public List<CareerVO> getTeacherCareer(String userId) {
		return teacherdao.getTeacherCareer(userId);
	}

	//강사-강사의 출퇴근 기록을 코드넘버 "2"를 통해서 조회
	@Override
	public List<Attendance> getTeacherTimeCard(String authorityCode) {
		return teacherdao.getTeacherTimeCard(authorityCode);
	}

	//원장-강사 출퇴근 기록을 코드넘버"2"를 통해서 조회
	@Override
	public List<Attendance> getManagerTeacherTimeCard(String authorityCode) {
		return teacherdao.getManagerTeacherTimeCard(authorityCode);
	}

	//강사 삭제
	@Override
	public void deleteTeacher(String userId) {
		 teacherdao.deleteTeacher(userId);
	}

	
	@Override
	public List<Attendance> getTeacherTimeCardByDate(String attendanceGoTime) {
		return teacherdao.getTeacherTimeCardByDate(attendanceGoTime);
	}


	@Override
	public List<Attendance> getAttendanceType(String attendanceStateName) {
		return teacherdao.getgetAttendanceType(attendanceStateName);
	}


	
}
