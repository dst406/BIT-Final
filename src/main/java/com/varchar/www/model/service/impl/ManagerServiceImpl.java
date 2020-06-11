package com.varchar.www.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varchar.www.model.dao.ManagerDAO;
import com.varchar.www.model.domain.manager.Season;
import com.varchar.www.model.domain.manager.Teacher;
import com.varchar.www.model.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerDAO managerDAO;
	
	@Override
	public List<Teacher> getTeacherList(String authority_code) {
		
		return managerDAO.getTeacherList(authority_code);
	}

	@Override
	public List<Season> getSeasonList() {
		return managerDAO.getSeasonList();
	}

}
