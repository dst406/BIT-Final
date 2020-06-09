package com.varchar.www.model.dao;

import java.util.List;

import com.varchar.www.model.domain.board.BoardGroupList;


public interface BoardDAO {
	List<BoardGroupList> getNavbar(String userId);
}
