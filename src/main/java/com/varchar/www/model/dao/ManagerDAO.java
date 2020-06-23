package com.varchar.www.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.varchar.www.model.domain.manager.CareerVO;
import com.varchar.www.model.domain.manager.Season;
import com.varchar.www.model.domain.teacher.Teacher;

@Mapper
public interface ManagerDAO {
	
	List<Teacher> getTeacherList(String authority_code);
	Teacher getManagerInfo(String authorityCode);
	List<CareerVO> getManagerCareer(String userId);
	List<Season> getSeasonList();

}
