package com.varchar.www.model.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.varchar.www.model.dao.ManagerDAO;
import com.varchar.www.model.domain.manager.CareerVO;
import com.varchar.www.model.domain.manager.MonthlyIncome;
import com.varchar.www.model.domain.manager.Season;
import com.varchar.www.model.domain.page.Criteria;
import com.varchar.www.model.domain.teacher.Teacher;
import com.varchar.www.model.domain.teacher.TeacherVO;
import com.varchar.www.model.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerDAO managerDAO;
	
	//private static final String uploadDirectory = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img\\";
	private static final String uploadDirectory ="C:/varchar/userImg/";
	
	
	@Override
	public List<Teacher> getManagerTeacherList(Criteria cri, String authority_code) {		
		return managerDAO.getManagerTeacherList(cri, authority_code);
	}

	@Override
	public List<Season> getSeasonList() {
		return managerDAO.getSeasonList();
	}

	@Override
	public Teacher getManagerInfo(String authorityCode) {
		return managerDAO.getManagerInfo(authorityCode);
	}

	@Override
	public List<CareerVO> getManagerCareer(String userId) {
		return managerDAO.getManagerCareer(userId);
	}

	@Override
	public void uploadManagerImage(MultipartFile imgFile) {
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
	public void updateManagerInfo(TeacherVO manager) {
		managerDAO.updateManagerInfo(manager);
		
	}

	@Override
	public List<MonthlyIncome> getMonthlyIncome() {
		return managerDAO.getMonthlyIncome();
	}

}
