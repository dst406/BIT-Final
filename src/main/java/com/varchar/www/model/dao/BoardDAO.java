package com.varchar.www.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.varchar.www.model.domain.board.BoardGroupList;


public interface BoardDAO {
	List<BoardGroupList> getNavbar(String userId);
	void insertBoardGroup(@Param("content")String content, @Param("lectureCode")String lectureCode);
}
