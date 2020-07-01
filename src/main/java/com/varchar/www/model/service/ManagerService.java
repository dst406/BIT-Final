package com.varchar.www.model.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.varchar.www.model.domain.manager.CareerVO;
import com.varchar.www.model.domain.manager.Season;
import com.varchar.www.model.domain.page.Criteria;
import com.varchar.www.model.domain.teacher.Teacher;
import com.varchar.www.model.domain.teacher.TeacherVO;

public interface ManagerService {
	
	List<Teacher> getManagerTeacherList(Criteria cri, String authority_code);
	Teacher getManagerInfo(String authorityCode);
	List<CareerVO> getManagerCareer(String userId);
	List<Season> getSeasonList();
	void uploadManagerImage(MultipartFile imgFile);
	void updateManagerInfo(TeacherVO manager);
}
