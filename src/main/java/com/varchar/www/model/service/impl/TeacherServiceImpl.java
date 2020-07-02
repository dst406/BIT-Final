package com.varchar.www.model.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.varchar.www.model.dao.TeacherDAO;
import com.varchar.www.model.domain.manager.Attendance;
import com.varchar.www.model.domain.manager.CareerVO;
import com.varchar.www.model.domain.page.Criteria;
import com.varchar.www.model.domain.teacher.AttendanceState;
import com.varchar.www.model.domain.teacher.Teacher;
import com.varchar.www.model.domain.teacher.TeacherVO;
import com.varchar.www.model.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	private TeacherDAO teacherdao;
	
	private static final String uploadDirectory = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img\\";
	
	//강사 등록
	@Override
	public void insertTeacher(Teacher teacher) {
		System.err.println(teacher);
		teacherdao.insertTeacher(teacher);
		teacherdao.insertCareer(teacher);
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

	//강사-강사의 출퇴근 Id를 통해서 조회
	@Override
	public List<Attendance> getTeacherTimeCard(Criteria cri, String userId) {
		cri.setAmount(20);
		return teacherdao.getTeacherTimeCard(cri, userId);
	}

	//원장-강사 출퇴근 기록을 코드넘버"2"를 통해서 조회
	@Override
	public List<Attendance> getManagerTeacherTimeCard(Criteria cri, String authorityCode) {
		cri.setAmount(20);
		return teacherdao.getManagerTeacherTimeCard(cri,authorityCode);
	}

	//강사 삭제
	@Override
	public void deleteTeacher(String userId) {
		 teacherdao.deleteTeacher(userId);
	}

	
	/*
	 * @Override public List<Attendance> getTeacherTimeCardByDate(String
	 * attendanceGoTime) { return
	 * teacherdao.getTeacherTimeCardByDate(attendanceGoTime); }
	 */


	@Override
	public List<Attendance> getAttendanceType(Criteria cri, String attendanceStateName, String attendanceGoTime) {
		cri.setAmount(20);
		if(attendanceStateName.equals("전체") && attendanceGoTime.equals("0")) return teacherdao.getManagerTeacherTimeCard(cri,"2");
		else if(!attendanceStateName.equals("전체") && attendanceGoTime.equals("0")) return teacherdao.getAttendanceType(cri, attendanceStateName);
		else if(attendanceStateName.equals("전체") && !attendanceGoTime.equals("0")) return teacherdao.getTeacherTimeCardByDate(cri, attendanceGoTime);
		return teacherdao.getAttendanceSearch(cri, attendanceStateName, attendanceGoTime);
	}

	@Override
	public void uploadTeacherImage(MultipartFile imgFile) {
		File file = new File(uploadDirectory);
		
		if (file.exists() == false) {
			file.mkdirs();
		}
		
		try {
			file = new File(uploadDirectory + imgFile.getOriginalFilename());
			imgFile.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Teacher> getTeacherList(String authority_code) {
		return teacherdao.getTeacherList(authority_code);
	}

	@Override
	public int getTeacherAccount(String authorityCode) {
		return teacherdao.getTeacherAccount(authorityCode);
	}

	@Override
	public int getManagerTeacherTimdCardAccount(String authorityCode) {
		return teacherdao.getManagerTeacherTimdCardAccount(authorityCode);
	}

	@Override
	public int getAttendanceTypeAccount(String attendanceStateName, String attendanceGoTime) {
		if(attendanceStateName.equals("전체") && attendanceGoTime.equals("0")) return teacherdao.getManagerTeacherTimdCardAccount("2");
		else if(!attendanceStateName.equals("전체") && attendanceGoTime.equals("0")) return teacherdao.getAttendanceTypeAccount(attendanceStateName);
		else if(attendanceStateName.equals("전체") && !attendanceGoTime.equals("0")) return teacherdao.getTeacherTimeCardByDateAccount(attendanceGoTime);
		return teacherdao.getAttendanceSearchAccount(attendanceStateName, attendanceGoTime);
	}

	@Override
	public List<AttendanceState> getAttendanceState() {
		List<AttendanceState> list = teacherdao.getAttendanceState();
		//System.err.println(list);
		return list;
	}

	@Override
	public int getTeacherTimeCardAccount(String userId) {
		// TODO Auto-generated method stub
		return teacherdao.getTeacherTimeCardAccount(userId);
	}

	@Override
	public List<Teacher> getTeacherListAll() {
		return teacherdao.getTeacherListAll();
	}

	@Override
	public void insertTeacherComeTime(String userId) {
		teacherdao.insertTeacherComeTime(userId);
		
	}

	@Override
	public void insertTeacherGoTime(String userId) {
		teacherdao.insertTeacherGoTime(userId);
		
	}

	
	

	
}
