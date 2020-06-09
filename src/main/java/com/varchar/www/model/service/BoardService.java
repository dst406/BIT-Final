package com.varchar.www.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.varchar.www.model.domain.board.BoardGroupList;


public interface BoardService {
	public List<BoardGroupList> getNavbar(String userId);
}
