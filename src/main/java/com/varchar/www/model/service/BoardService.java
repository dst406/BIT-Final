package com.varchar.www.model.service;

import java.util.List;

import com.varchar.www.model.domain.board.BoardGroupList;
import com.varchar.www.model.domain.board.PostDetail;
import com.varchar.www.model.domain.board.Posts;
import com.varchar.www.model.domain.board.PostsList;
import com.varchar.www.model.domain.board.TemporaryPost;
import com.varchar.www.model.domain.board.TemporaryPostList;
import com.varchar.www.model.domain.comment.Comment;


public interface BoardService {
	List<BoardGroupList> getNavbar(String userId);
	void insertBoardGroup(String content, String lectureCode);
	void updateBoardGroupName(String boardGroupName, String changeName,int boardGroupNo);
	void insertBoard (String content, int boardGroupNo);
	PostsList getPostList( int boardNo);
	PostDetail getPost(int boardNo, int postNo);
	void insertPosts(Posts posts);
	List<TemporaryPostList> getTemporaryPostList(String userId);
	List<Posts> getSearchDatePostList(int boardNo, String startDate, String endDate);
	void insertTemporaryPost(TemporaryPost temporaryPost);
	TemporaryPost getTemporaryPost(int temporaryNo);
	void insertPostComment(Comment comment, int postNo);
	void insertReply(Comment comment, int postNo);
}
