package com.varchar.www.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.varchar.www.model.domain.manager.Season;

@Mapper
public interface DAOTest {
	
	//@Select("select season_id from season")
	//public List<Season> getSeasonId();
	public List<Season> getSeasonId();
	
}
