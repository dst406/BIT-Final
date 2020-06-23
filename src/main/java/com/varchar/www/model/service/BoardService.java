package com.varchar.www.model.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.varchar.www.model.domain.board.BoardGroupList;
import com.varchar.www.model.domain.board.Posts;
import com.varchar.www.model.domain.board.PostsList;


public interface BoardService {
	public List<BoardGroupList> getNavbar(String userId);
	void insertBoardGroup(String content, String lectureCode);
	void updateBoardGroupName(String boardGroupName, String changeName,int boardGroupNo);
	void insertBoard (String content, int boardGroupNo);
	List<PostsList> getPostList( int boardNo);
	public Posts getPost();
}
