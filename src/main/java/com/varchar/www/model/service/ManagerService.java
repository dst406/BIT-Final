package com.varchar.www.model.service;

import java.util.List;

import com.varchar.www.model.dao.ManagerDAO;
import com.varchar.www.model.domain.manager.Season;
import com.varchar.www.model.domain.manager.Teacher;

public interface ManagerService {
	
	List<Teacher> getTeacherList(String authority_code);
	List<Season> getSeasonList();
}
