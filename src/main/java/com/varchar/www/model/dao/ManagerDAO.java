package com.varchar.www.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.varchar.www.model.domain.manager.Season;
import com.varchar.www.model.domain.manager.Teacher;

@Mapper
public interface ManagerDAO {
	
	List<Teacher> getTeacherList(String authority_code);
	List<Season> getSeasonList();
}
