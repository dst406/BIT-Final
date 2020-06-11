package com.varchar.www.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.varchar.www.model.domain.board.BoardGroupList;
import com.varchar.www.model.domain.board.PostDetail;
import com.varchar.www.model.domain.board.PostsList;


public interface BoardDAO {
	List<BoardGroupList> getNavbar(String userId);
	void insertBoardGroup(@Param("content")String content, @Param("lectureCode")String lectureCode);
	void updateBoardGroupName(@Param("boardGroupName")String boardGroupName,
							  @Param("changeBoardGroupName")String changeName,@Param("boardGroupNo")int boardGroupNo);
	void insertBoard (@Param("content")String content, @Param("boardGroupNo") int boardGroupNo);
	PostsList getPostList(int boardNo);
	
	// 게시글 Detail
	PostDetail getPost(@Param("boardNo") int boardNo,@Param("postNo") int postNo);
	
	
	
	
	void insertPosts(PostDetail posts);
}
