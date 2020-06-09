package com.varchar.www.model.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varchar.www.model.dao.BoardDAO;
import com.varchar.www.model.domain.board.BoardGroupList;
import com.varchar.www.model.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardDAO boardDAO;
	
	@Override
	public List<BoardGroupList> getNavbar(String userId) {
		
		return boardDAO.getNavbar(userId);
	}

}
