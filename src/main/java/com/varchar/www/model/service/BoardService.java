package com.varchar.www.model.service;

import java.util.List;

import com.varchar.www.model.domain.board.BoardGroupList;
import com.varchar.www.model.domain.board.PostDetail;
import com.varchar.www.model.domain.board.PostsList;


public interface BoardService {
	List<BoardGroupList> getNavbar(String userId);
	void insertBoardGroup(String content, String lectureCode);
	void updateBoardGroupName(String boardGroupName, String changeName,int boardGroupNo);
	void insertBoard (String content, int boardGroupNo);
	PostsList getPostList( int boardNo);
	PostDetail getPost(int boardNo, int postNo);
	void insertPosts(PostDetail posts);
}
