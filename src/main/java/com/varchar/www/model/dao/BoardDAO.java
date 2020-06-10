package com.varchar.www.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.varchar.www.model.domain.board.BoardGroupList;
import com.varchar.www.model.domain.board.Posts;
import com.varchar.www.model.domain.board.PostsList;


public interface BoardDAO {
	List<BoardGroupList> getNavbar(String userId);
	void insertBoardGroup(@Param("content")String content, @Param("lectureCode")String lectureCode);
	void updateBoardGroupName(@Param("boardGroupName")String boardGroupName,
							  @Param("changeBoardGroupName")String changeName,@Param("boardGroupNo")int boardGroupNo);
	void insertBoard (@Param("content")String content, @Param("boardGroupNo") int boardGroupNo);
	List<PostsList> getPostList(int boardNo);
	
	public Posts getPost();
	
}
