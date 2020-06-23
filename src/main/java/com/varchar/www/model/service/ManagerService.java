package com.varchar.www.model.service;

import java.util.List;

import com.varchar.www.model.domain.manager.CareerVO;
import com.varchar.www.model.domain.manager.Season;
import com.varchar.www.model.domain.teacher.Teacher;

public interface ManagerService {
	
	List<Teacher> getTeacherList(String authority_code);
	Teacher getManagerInfo(String authorityCode);
	List<CareerVO> getManagerCareer(String userId);
	List<Season> getSeasonList();
}
